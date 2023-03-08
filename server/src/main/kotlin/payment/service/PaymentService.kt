package payment.service

import io.grpc.Status
import io.grpc.StatusException
import payment.*
import payment.dao.PaymentMethodDao
import payment.dao.SaleDao
import payment.dto.PaymentMethod
import payment.utils.localDateTimeToString
import payment.utils.stringToLocalDateTime
import java.time.LocalDateTime

class PaymentService(saleRepo: SaleDao, paymentMethodRepo: PaymentMethodDao) : PaymentGrpcKt.PaymentCoroutineImplBase() {

    private var saleRepo: SaleDao = saleRepo
    private var paymentMethodRepo: PaymentMethodDao = paymentMethodRepo
    private fun isValidPriceMod(paymentMethod: PaymentMethod, priceMod: Float): Boolean {
        return priceMod in paymentMethod.priceModMin..paymentMethod.priceModMax
    }

    override suspend fun getSalesByHour(request: DateTimeRangeRequest): TotalSalesResponse = totalSalesResponse {
        // Validate request
        var startDate: LocalDateTime?
        var endDate: LocalDateTime?
        try {
            startDate = stringToLocalDateTime(request.startDateTime)
            endDate = stringToLocalDateTime(request.endDateTime)
        } catch (e: Exception) {
            throw StatusException(Status.INVALID_ARGUMENT.withDescription("Request validation failed with error: $e"))
        }

        // Fetch sales data
        var salesByHourArray = saleRepo.getSalesByHour(startDate, endDate)
        for (salesByHour in salesByHourArray) {
            sales += totalSales {
                this.sales = salesByHour.sales.toString()
                this.datetime = localDateTimeToString(salesByHour.datetime)
                this.points = salesByHour.points
            }
        }
    }

    override suspend fun makePayment(request: MakePaymentRequest): MakePaymentResponse {
        // Validate request
        var price: Float?
        var dateTime: LocalDateTime?
        try {
            price = request.price.toFloat()
            dateTime = stringToLocalDateTime(request.datetime)
        } catch (e: Exception) {
            throw StatusException(Status.INVALID_ARGUMENT.withDescription("Request validation failed with error: $e"))
        }

        // Validate price modifier and calculate final price
        val paymentMethod = paymentMethodRepo.getByName(request.paymentMethod)
        if (!isValidPriceMod(paymentMethod, request.priceModifier)) {
            val errorDescription = String.format(
                "Invalid price multiplier: %s payment is set to accept multipliers between %.2f and %.2f",
                paymentMethod.paymentMethod,
                paymentMethod.priceModMin,
                paymentMethod.priceModMax
            )
            throw StatusException(Status.FAILED_PRECONDITION.withDescription(errorDescription))
        }
        val finalPrice = price * request.priceModifier
        val finalPoints = (price * paymentMethod.pointMultiplier).toInt()

        // Save payment to DB
        saleRepo.createSale(finalPrice, finalPoints, request.paymentMethod, dateTime)
        return makePaymentResponse {
            this.finalPrice = finalPrice.toString()
            this.points = points
        }
    }
}

