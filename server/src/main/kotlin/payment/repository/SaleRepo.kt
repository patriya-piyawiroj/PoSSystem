package payment.repository

import com.zaxxer.hikari.HikariDataSource
import io.grpc.Status
import io.grpc.StatusException
import mu.KotlinLogging
import payment.config.DatabaseConfig
import payment.dao.SaleDao
import payment.dto.TotalSale
import java.sql.Connection
import java.time.LocalDateTime

class SaleRepo(config: DatabaseConfig) : SaleDao {
    private var connection: Connection
    private val logger = KotlinLogging.logger {}

    init {
        val dataSource = HikariDataSource()
        dataSource.jdbcUrl = "jdbc:${config.driver}://${config.hostUrl}:${config.port}/${config.name}"
        dataSource.username = config.username
        dataSource.password = config.password
        connection = dataSource.connection
    }

    override fun createSale(
        salePrice: Float,
        earnedPoints: Int,
        paymentMethod: String,
        datetime: LocalDateTime
    ) {
        try {
            logger.debug("Created sale with paymentMethod:$paymentMethod finalPrice:$salePrice, finalPoints:$earnedPoints")
            val statement =
                "INSERT INTO sale (sale_price, earned_points, payment_method, sale_datetime) VALUES ($salePrice,$earnedPoints,'$paymentMethod','$datetime')"
            val query = connection.prepareStatement(statement)
            query.execute()
        } catch (e: Exception) {
            throw StatusException(Status.INTERNAL.withDescription("Database failed with error $e"))
        }
    }

    override fun getSalesByHour(startDate: LocalDateTime, endDate: LocalDateTime): MutableList<TotalSale> {
        try {
            // Timestamp precision below by 3600 seconds (1 hour) is divided out
            val statement = "SELECT  \n" +
                "\tSUM(sale_price) AS sum_sales, \n" +
                "\tSUM(earned_points) AS sum_points, \n" +
                "\tto_timestamp(floor((extract('epoch' from sale_datetime) / 3600 )) * 3600) AT TIME ZONE 'UTC' as hourly_sale\n" +
                "FROM sale \n" +
                "WHERE sale_datetime BETWEEN '$startDate' AND '$endDate\n'" +
                "GROUP BY hourly_sale\n" +
                "ORDER BY hourly_sale;"
            val query = connection.prepareStatement(statement)
            val result = query.executeQuery()
            var salesByHour = mutableListOf<TotalSale>()
            while (result.next()) {
                salesByHour.add(
                    TotalSale(
                        result.getTimestamp("hourly_sale").toLocalDateTime(),
                        result.getFloat("sum_sales"),
                        result.getInt("sum_points")
                    )
                )
            }
            return salesByHour
        } catch (e: Exception) {
            throw StatusException(Status.INTERNAL.withDescription("Database failed with error $e"))
        }
    }
}
