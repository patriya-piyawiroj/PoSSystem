package payment.config

data class ApplicationConfig(
    val port: Int,
    val db: DatabaseConfig
)

data class DatabaseConfig(
    val hostUrl: String,
    val driver: String,
    val port: Int,
    val username: String,
    val password: String,
    val name: String,
    val poolSize: Int
)
