package payment

import io.grpc.Status
import io.grpc.StatusException
import io.grpc.testing.GrpcServerRule
import kotlinx.coroutines.runBlocking
import org.junit.Rule
import org.junit.Test
import org.mockito.Mockito
import org.mockito.kotlin.any
import payment.dao.PaymentMethodDao
import payment.dao.SaleDao
import payment.dto.PaymentMethod
import payment.dto.TotalSale
import payment.service.PaymentService
import payment.utils.localDateTimeToString
import java.time.LocalDateTime
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith

class PaymentServiceTest {

    @get:Rule
    val grpcServerRule: GrpcServerRule = GrpcServerRule().directExecutor()

    private val formattedDateTime = "2022-09-01T00:00:00Z"

    private class MockGetSalesRequest(startDate: String, endDate: String) {
        var startDate: String = startDate
        var endDate: String = endDate
    }

    private class MockMakePaymentRequest(price: String, dateTime: String) {
        var price: String = price
        var dateTime: String = dateTime
    }

    @Test
    fun getSalesByHour_success() {
        // Set up
        val localTime = LocalDateTime.now()
        val expectedTotalSale = TotalSale(localTime, 100.0F, 10)

        // Mock
        val mockSaleRepo = Mockito.mock(SaleDao::class.java)
        val mockPaymentMethodRepo = Mockito.mock(PaymentMethodDao::class.java)
        Mockito.`when`(mockSaleRepo.getSalesByHour(localTime, localTime))
            .thenReturn(MutableList(1) { expectedTotalSale })

        // Execute
        runBlocking {
            val paymentService = PaymentService(mockSaleRepo, mockPaymentMethodRepo)
            grpcServerRule.serviceRegistry.addService(paymentService)

            val paymentStub = PaymentGrpcKt.PaymentCoroutineStub(grpcServerRule.channel)
            val salesByHour = paymentStub.getSalesByHour(dateTimeRangeRequest {
                this.startDateTime = localDateTimeToString(localTime); this.endDateTime = localDateTimeToString(localTime)
            })
            val totalSale = salesByHour.getSales(0)
            assertEquals(totalSale.sales.toFloat(), expectedTotalSale.sales)
            assertEquals(totalSale.datetime, localDateTimeToString(expectedTotalSale.datetime))
            assertEquals(totalSale.points, expectedTotalSale.points)

        }
    }

    @Test
    fun getSalesByHour_invalidRequest_thenThrowsInvalidArgumentException() {
        // Setup Tests
        val getSalesRequests: Array<MockGetSalesRequest> = Array(2) {
            // Invalid start date
            MockGetSalesRequest("", formattedDateTime)
            // Invalid end date
            MockGetSalesRequest(formattedDateTime, "")
        }

        // Mock
        val mockSaleRepo = Mockito.mock(SaleDao::class.java)
        val mockPaymentMethodRepo = Mockito.mock(PaymentMethodDao::class.java)

        // Execute
        for (request in getSalesRequests) {
            val exception = assertFailsWith<StatusException>(
                block = {
                    runBlocking {
                        val paymentService = PaymentService(mockSaleRepo, mockPaymentMethodRepo)
                        grpcServerRule.serviceRegistry.addService(paymentService)

                        val paymentStub = PaymentGrpcKt.PaymentCoroutineStub(grpcServerRule.channel)
                        paymentStub.getSalesByHour(dateTimeRangeRequest {
                            this.startDateTime = request.startDate; this.endDateTime = request.endDate
                        })
                    }
                }
            )
            assertEquals(Status.INVALID_ARGUMENT.code, exception.status.code)
        }
    }

    @Test
    fun makePayment_invalidRequest_thenThrowsInvalidArgumentException() {
        // Setup Tests
        val makePaymentRequests: Array<MockMakePaymentRequest> = Array(2) {
            // Invalid price
            MockMakePaymentRequest("", formattedDateTime)
            // Invalid datetime
            MockMakePaymentRequest("100.0", "")
        }

        // Mock
        val mockSaleRepo = Mockito.mock(SaleDao::class.java)
        val mockPaymentMethodRepo = Mockito.mock(PaymentMethodDao::class.java)

        // Execute
        for (request in makePaymentRequests) {
            val exception = assertFailsWith<StatusException>(
                block = {
                    runBlocking {
                        val paymentService = PaymentService(mockSaleRepo, mockPaymentMethodRepo)
                        grpcServerRule.serviceRegistry.addService(paymentService)

                        val paymentStub = PaymentGrpcKt.PaymentCoroutineStub(grpcServerRule.channel)
                        paymentStub.makePayment(makePaymentRequest {
                            this.price = request.price; this.datetime = request.dateTime
                        })
                    }
                }
            )
            assertEquals(Status.INVALID_ARGUMENT.code, exception.status.code)
        }
    }

    @Test
    fun makePayment_invalidPriceModifier_thenThrowsFailedPreconditionException() {
        // Setup
        val priceModifiers = floatArrayOf(
            // Block < minimum price modifier
            2.0F,
            // Block > maximum price modifier
            0.0F,
        )

        // Mock
        val mockSaleRepo = Mockito.mock(SaleDao::class.java)
        val mockPaymentMethodRepo = Mockito.mock(PaymentMethodDao::class.java)
        Mockito.`when`(mockPaymentMethodRepo.getByName(any())).thenReturn(PaymentMethod("", 1.0F, 1.0F, 1.0F))

        // Execute
        for (priceModifier in priceModifiers) {
            println(priceModifier)
            val exception = assertFailsWith<StatusException>(
                block = {
                    runBlocking {
                        val paymentService = PaymentService(mockSaleRepo, mockPaymentMethodRepo)
                        grpcServerRule.serviceRegistry.addService(paymentService)
                        val paymentStub = PaymentGrpcKt.PaymentCoroutineStub(grpcServerRule.channel)
                        paymentStub.makePayment(makePaymentRequest {
                            this.price = "100.0"; this.datetime = formattedDateTime; this.priceModifier = priceModifier
                        })
                    }
                }
            )
            assertEquals(Status.FAILED_PRECONDITION.code, exception.status.code)
        }
    }


    @Test
    fun makePayment_success() {

        runBlocking {
            // Mock
            val mockSaleRepo = Mockito.mock(SaleDao::class.java)
            val mockPaymentMethodRepo = Mockito.mock(PaymentMethodDao::class.java)
            Mockito.`when`(mockPaymentMethodRepo.getByName(any())).thenReturn(PaymentMethod("", 1.0F, 0.0F, 1.0F))

            // Execute
            val paymentService = PaymentService(mockSaleRepo, mockPaymentMethodRepo)
            grpcServerRule.serviceRegistry.addService(paymentService)
            val paymentStub = PaymentGrpcKt.PaymentCoroutineStub(grpcServerRule.channel)
            paymentStub.makePayment(makePaymentRequest {
                this.paymentMethod = ""
                this.price = "100.0"
                this.priceModifier = 1.0F
                this.datetime = formattedDateTime
            })
        }
    }
}
