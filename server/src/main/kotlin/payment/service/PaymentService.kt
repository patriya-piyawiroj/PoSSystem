package payment.service

import io.grpc.ManagedChannel
import io.grpc.Status
import io.grpc.StatusException
import payment.*
import payment.dao.SaleDao
import payment.repository.SaleRepo
import payment.utils.localDateTimeToString
import payment.utils.stringToLocalDateTime
import pricing.PricingGrpcKt
import pricing.calculateFinalPriceAndPointsRequest
import java.time.LocalDateTime

class PaymentService(channel: ManagedChannel) : PaymentGrpcKt.PaymentCoroutineImplBase() {

    private val pricingServiceStub: PricingGrpcKt.PricingCoroutineStub = PricingGrpcKt.PricingCoroutineStub(channel)
    private var saleRepo: SaleDao = SaleRepo()

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
            var s = salesByHour
            println(s.sales.toString() + " " + s.datetime.toString())
            sales += totalSales {
                this.sales = salesByHour.sales.toString()
                this.datetime = localDateTimeToString(salesByHour.datetime)
                this.points = salesByHour.points
            }
        }
    }

    override suspend fun confirmPaymentMethod(request: ConfirmPaymentMethodRequest): ConfirmPaymentMethodResponse {
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
        val calculatePriceRequest = calculateFinalPriceAndPointsRequest {
            this.paymentMethod = request.paymentMethod
            this.price = price
            this.priceModifier = request.priceModifier
        }
        val finalPriceAndPoints = pricingServiceStub.calculateFinalPriceAndPoints(calculatePriceRequest)

        // Save payment to DB
        saleRepo.createSale(finalPriceAndPoints.finalPrice, finalPriceAndPoints.points, request.paymentMethod, dateTime)
        return confirmPaymentMethodResponse {
            this.finalPrice = finalPriceAndPoints.finalPrice.toString()
            this.points = finalPriceAndPoints.points
        }
    }
}

