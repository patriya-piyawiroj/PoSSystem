package payment.server

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory
import com.fasterxml.jackson.module.kotlin.KotlinModule
import com.fasterxml.jackson.module.kotlin.MissingKotlinParameterException
import io.grpc.Server
import io.grpc.ServerBuilder
import io.grpc.Status
import io.grpc.StatusException
import mu.KotlinLogging
import payment.config.ApplicationConfig
import payment.dao.PaymentMethodDao
import payment.dao.SaleDao
import payment.repository.PaymentMethodRepo
import payment.repository.SaleRepo
import payment.service.PaymentService
import java.nio.file.Files
import java.nio.file.Paths

private val logger = KotlinLogging.logger {}

class PaymentServer constructor(private val config: ApplicationConfig) {

    private val saleRepo: SaleDao = SaleRepo(config.db)
    private val paymentMethodRepo: PaymentMethodDao = PaymentMethodRepo(config.db)
    private val server: Server = ServerBuilder
        .forPort(config.port)
        .addService(PaymentService(saleRepo, paymentMethodRepo))
        .build()

    fun start() {
        server.start()
        logger.info("Server started, listening on ${config.port}")
        Runtime.getRuntime().addShutdownHook(
            Thread {
                logger.info("*** shutting down gRPC server since JVM is shutting down")
                this@PaymentServer.stop()
                logger.info("*** server shut down")
            }
        )
    }

    private fun stop() {
        server.shutdown()
    }

    fun blockUntilShutdown() {
        server.awaitTermination()
    }
}

fun parse(): ApplicationConfig {
    val base = Paths.get("").toAbsolutePath().toString()
    var configPath = "$base/src/main/kotlin/payment/config"
    val path = Paths.get(configPath, "application.yaml")
    val mapper = ObjectMapper(YAMLFactory())
    mapper.registerModule(KotlinModule())

    logger.info("Reading application configs from $configPath")
    return try {
        Files.newBufferedReader(path).use {
            mapper.readValue(it, ApplicationConfig::class.java)
        }
    } catch (exception: MissingKotlinParameterException) {
        logger.error(exception.toString())
        throw StatusException(Status.INTERNAL.withDescription("Missing parameter. Unable to parse config"))
    }
}

fun main() {
    val config = parse()
    val server = PaymentServer(config)
    server.start()
    server.blockUntilShutdown()
}
