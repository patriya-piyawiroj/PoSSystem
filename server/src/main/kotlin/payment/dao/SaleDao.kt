package payment.dao

import payment.dto.TotalSale
import java.time.LocalDateTime

interface SaleDao {
    fun createSale(salePrice: Float, earnedPoints: Int, paymentMethod: String, datetime: LocalDateTime)
    fun getSalesByHour(startDate: LocalDateTime, endDate: LocalDateTime): MutableList<TotalSale>
}
