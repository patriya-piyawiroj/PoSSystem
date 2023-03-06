package payment.service

import io.grpc.Status
import io.grpc.StatusException
import payment.dao.PaymentMethodDao
import payment.dto.PaymentMethod
import payment.repository.PaymentMethodRepo
import pricing.CalculateFinalPriceAndPointResponse
import pricing.PricingGrpcKt
import pricing.calculateFinalPriceAndPointResponse

class PricingService : PricingGrpcKt.PricingCoroutineImplBase() {

    private var paymentMethodRepo: PaymentMethodDao = PaymentMethodRepo()

    private fun isValidPriceMod(paymentMethod: PaymentMethod, priceMod: Float): Boolean {
        return priceMod in paymentMethod.priceModMin..paymentMethod.priceModMax
    }

    override suspend fun calculateFinalPriceAndPoints(request: pricing.CalculateFinalPriceAndPointsRequest): CalculateFinalPriceAndPointResponse {

        return calculateFinalPriceAndPointResponse {
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
            this.finalPrice = request.price * request.priceModifier
            this.points = (request.price * paymentMethod.pointMultiplier).toInt()
        }
    }

}