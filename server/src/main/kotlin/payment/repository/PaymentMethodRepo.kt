package payment.repository

import com.zaxxer.hikari.HikariDataSource
import io.grpc.Status
import io.grpc.StatusException
import payment.dao.PaymentMethodDao
import payment.dto.PaymentMethod
import java.sql.Connection

class PaymentMethodRepo : PaymentMethodDao {
    private var connection: Connection

    init {
        val dataSource = HikariDataSource()
        dataSource.jdbcUrl = "jdbc:postgresql://localhost:5432/pos"
        dataSource.username = "admin"
        dataSource.password = "admin"
        connection = dataSource.connection
    }

    override fun getByName(name: String): PaymentMethod {
        try {
            val query = connection.prepareStatement("SELECT * FROM payment_method WHERE name='$name'")
            val result = query.executeQuery()
            while (result.next()) {
                return PaymentMethod(
                    result.getString("name"),
                    result.getFloat("price_modifier_max"),
                    result.getFloat("price_modifier_min"),
                    result.getFloat("point_multiplier")
                )
            }
        } catch (e: Exception) {
            throw StatusException(Status.INTERNAL.withDescription("Database failed with error $e"))
        }
        // No results from query
        throw StatusException(Status.FAILED_PRECONDITION.withDescription("Payment method not found: $name"))
    }
}
