package payment.dto

data class PaymentMethod(
    val paymentMethod: String,
    val priceModMax: Float,
    val priceModMin: Float,
    val pointMultiplier: Float
)
