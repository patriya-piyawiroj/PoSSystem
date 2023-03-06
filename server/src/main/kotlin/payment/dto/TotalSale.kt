package payment.dto

import java.time.LocalDateTime

data class TotalSale(
    val datetime: LocalDateTime,
    val sales: Float,
    val points: Int,
)
