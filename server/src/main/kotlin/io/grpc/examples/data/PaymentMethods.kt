package io.grpc.examples.data

import java.sql.DriverManager

data class PaymentMethod(val paymentMethod: String, val priceModMax: Float, val priceModMin: Float, val pointMultiplier: Float)
fun main() {
    val jdbcUrl = "jdbc:postgresql://localhost:5432/pos"
    val connection = DriverManager
        .getConnection(jdbcUrl, "admin", "admin")
    println(connection.isValid(0))
    val query = connection.prepareStatement("SELECT * FROM pricing")

    // the query is executed and results are fetched
    val result = query.executeQuery()

    // an empty list for holding the results
    val users = mutableListOf<PaymentMethod>()

    while(result.next()){

        // getting the value of the name column
        val name = result.getString("payment_method")
        println(name)
        /*
        constructing a User object and
        putting data into the list
         */
//        users.add(PaymentMethod(id, name))
    }
}