package io.grpc.examples.animals

import io.grpc.CallOptions
import io.grpc.CallOptions.DEFAULT
import io.grpc.Channel
import io.grpc.Metadata
import io.grpc.MethodDescriptor
import io.grpc.ServerServiceDefinition
import io.grpc.ServerServiceDefinition.builder
import io.grpc.ServiceDescriptor
import io.grpc.Status
import io.grpc.Status.UNIMPLEMENTED
import io.grpc.StatusException
import io.grpc.examples.animals.DogGrpc.getServiceDescriptor
import io.grpc.kotlin.AbstractCoroutineServerImpl
import io.grpc.kotlin.AbstractCoroutineStub
import io.grpc.kotlin.ClientCalls
import io.grpc.kotlin.ClientCalls.unaryRpc
import io.grpc.kotlin.ServerCalls
import io.grpc.kotlin.ServerCalls.unaryServerMethodDefinition
import io.grpc.kotlin.StubFor
import kotlin.String
import kotlin.coroutines.CoroutineContext
import kotlin.coroutines.EmptyCoroutineContext
import kotlin.jvm.JvmOverloads
import kotlin.jvm.JvmStatic

/**
 * Holder for Kotlin coroutine-based client and server APIs for animals.Dog.
 */
public object DogGrpcKt {
  public const val SERVICE_NAME: String = DogGrpc.SERVICE_NAME

  @JvmStatic
  public val serviceDescriptor: ServiceDescriptor
    get() = DogGrpc.getServiceDescriptor()

  public val calculateFinalPriceAndPointsMethod:
      MethodDescriptor<CalculateFinalPriceAndPointsRequest, CalculateFinalPriceAndPointResponse>
    @JvmStatic
    get() = DogGrpc.getCalculateFinalPriceAndPointsMethod()

  public val getSalesByHourMethod: MethodDescriptor<DateTimeRangeRequest, SalesByHourResponse>
    @JvmStatic
    get() = DogGrpc.getGetSalesByHourMethod()

  public val barkMethod: MethodDescriptor<BarkRequest, BarkReply>
    @JvmStatic
    get() = DogGrpc.getBarkMethod()

  /**
   * A stub for issuing RPCs to a(n) animals.Dog service as suspending coroutines.
   */
  @StubFor(DogGrpc::class)
  public class DogCoroutineStub @JvmOverloads constructor(
    channel: Channel,
    callOptions: CallOptions = DEFAULT,
  ) : AbstractCoroutineStub<DogCoroutineStub>(channel, callOptions) {
    public override fun build(channel: Channel, callOptions: CallOptions): DogCoroutineStub =
        DogCoroutineStub(channel, callOptions)

    /**
     * Executes this RPC and returns the response message, suspending until the RPC completes
     * with [`Status.OK`][Status].  If the RPC completes with another status, a corresponding
     * [StatusException] is thrown.  If this coroutine is cancelled, the RPC is also cancelled
     * with the corresponding exception as a cause.
     *
     * @param request The request message to send to the server.
     *
     * @param headers Metadata to attach to the request.  Most users will not need this.
     *
     * @return The single response from the server.
     */
    public suspend fun calculateFinalPriceAndPoints(request: CalculateFinalPriceAndPointsRequest,
        headers: Metadata = Metadata()): CalculateFinalPriceAndPointResponse = unaryRpc(
      channel,
      DogGrpc.getCalculateFinalPriceAndPointsMethod(),
      request,
      callOptions,
      headers
    )

    /**
     * Executes this RPC and returns the response message, suspending until the RPC completes
     * with [`Status.OK`][Status].  If the RPC completes with another status, a corresponding
     * [StatusException] is thrown.  If this coroutine is cancelled, the RPC is also cancelled
     * with the corresponding exception as a cause.
     *
     * @param request The request message to send to the server.
     *
     * @param headers Metadata to attach to the request.  Most users will not need this.
     *
     * @return The single response from the server.
     */
    public suspend fun getSalesByHour(request: DateTimeRangeRequest, headers: Metadata =
        Metadata()): SalesByHourResponse = unaryRpc(
      channel,
      DogGrpc.getGetSalesByHourMethod(),
      request,
      callOptions,
      headers
    )

    /**
     * Executes this RPC and returns the response message, suspending until the RPC completes
     * with [`Status.OK`][Status].  If the RPC completes with another status, a corresponding
     * [StatusException] is thrown.  If this coroutine is cancelled, the RPC is also cancelled
     * with the corresponding exception as a cause.
     *
     * @param request The request message to send to the server.
     *
     * @param headers Metadata to attach to the request.  Most users will not need this.
     *
     * @return The single response from the server.
     */
    public suspend fun bark(request: BarkRequest, headers: Metadata = Metadata()): BarkReply =
        unaryRpc(
      channel,
      DogGrpc.getBarkMethod(),
      request,
      callOptions,
      headers
    )
  }

  /**
   * Skeletal implementation of the animals.Dog service based on Kotlin coroutines.
   */
  public abstract class DogCoroutineImplBase(
    coroutineContext: CoroutineContext = EmptyCoroutineContext,
  ) : AbstractCoroutineServerImpl(coroutineContext) {
    /**
     * Returns the response to an RPC for animals.Dog.CalculateFinalPriceAndPoints.
     *
     * If this method fails with a [StatusException], the RPC will fail with the corresponding
     * [Status].  If this method fails with a [java.util.concurrent.CancellationException], the RPC
     * will fail
     * with status `Status.CANCELLED`.  If this method fails for any other reason, the RPC will
     * fail with `Status.UNKNOWN` with the exception as a cause.
     *
     * @param request The request from the client.
     */
    public open suspend
        fun calculateFinalPriceAndPoints(request: CalculateFinalPriceAndPointsRequest):
        CalculateFinalPriceAndPointResponse = throw
        StatusException(UNIMPLEMENTED.withDescription("Method animals.Dog.CalculateFinalPriceAndPoints is unimplemented"))

    /**
     * Returns the response to an RPC for animals.Dog.GetSalesByHour.
     *
     * If this method fails with a [StatusException], the RPC will fail with the corresponding
     * [Status].  If this method fails with a [java.util.concurrent.CancellationException], the RPC
     * will fail
     * with status `Status.CANCELLED`.  If this method fails for any other reason, the RPC will
     * fail with `Status.UNKNOWN` with the exception as a cause.
     *
     * @param request The request from the client.
     */
    public open suspend fun getSalesByHour(request: DateTimeRangeRequest): SalesByHourResponse =
        throw
        StatusException(UNIMPLEMENTED.withDescription("Method animals.Dog.GetSalesByHour is unimplemented"))

    /**
     * Returns the response to an RPC for animals.Dog.Bark.
     *
     * If this method fails with a [StatusException], the RPC will fail with the corresponding
     * [Status].  If this method fails with a [java.util.concurrent.CancellationException], the RPC
     * will fail
     * with status `Status.CANCELLED`.  If this method fails for any other reason, the RPC will
     * fail with `Status.UNKNOWN` with the exception as a cause.
     *
     * @param request The request from the client.
     */
    public open suspend fun bark(request: BarkRequest): BarkReply = throw
        StatusException(UNIMPLEMENTED.withDescription("Method animals.Dog.Bark is unimplemented"))

    public final override fun bindService(): ServerServiceDefinition =
        builder(getServiceDescriptor())
      .addMethod(unaryServerMethodDefinition(
      context = this.context,
      descriptor = DogGrpc.getCalculateFinalPriceAndPointsMethod(),
      implementation = ::calculateFinalPriceAndPoints
    ))
      .addMethod(unaryServerMethodDefinition(
      context = this.context,
      descriptor = DogGrpc.getGetSalesByHourMethod(),
      implementation = ::getSalesByHour
    ))
      .addMethod(unaryServerMethodDefinition(
      context = this.context,
      descriptor = DogGrpc.getBarkMethod(),
      implementation = ::bark
    )).build()
  }
}
