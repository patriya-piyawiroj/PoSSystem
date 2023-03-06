package payment.dao

import payment.dto.PaymentMethod

interface PaymentMethodDao {
    fun getByName(name: String): PaymentMethod
}
