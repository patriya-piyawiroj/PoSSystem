package payment.repository

import com.zaxxer.hikari.HikariDataSource
import io.grpc.Status
import io.grpc.StatusException
import payment.config.DatabaseConfig
import payment.dao.PaymentMethodDao
import payment.dto.PaymentMethod
import java.sql.Connection

class PaymentMethodRepo(config: DatabaseConfig) : PaymentMethodDao {
    private var connection: Connection

    init {
        val dataSource = HikariDataSource()
        dataSource.maximumPoolSize = config.poolSize
        dataSource.jdbcUrl = "jdbc:${config.driver}://${config.hostUrl}:${config.port}/${config.name}"
        dataSource.username = config.username
        dataSource.password = config.password
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
        throw StatusException(Status.UNIMPLEMENTED.withDescription("Unhandled payment method : $name"))
    }
}
