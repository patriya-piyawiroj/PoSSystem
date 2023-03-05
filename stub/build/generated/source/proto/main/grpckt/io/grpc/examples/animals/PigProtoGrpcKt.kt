package io.grpc.examples.animals

import io.grpc.CallOptions
import io.grpc.CallOptions.DEFAULT
import io.grpc.Channel
import io.grpc.Metadata
import io.grpc.MethodDescriptor
import io.grpc.ServerServiceDefinition
import io.grpc.ServerServiceDefinition.builder
import io.grpc.ServiceDescriptor
import io.grpc.Status.UNIMPLEMENTED
import io.grpc.StatusException
import io.grpc.examples.animals.PigGrpc.getServiceDescriptor
import io.grpc.kotlin.AbstractCoroutineServerImpl
import io.grpc.kotlin.AbstractCoroutineStub
import io.grpc.kotlin.ClientCalls.unaryRpc
import io.grpc.kotlin.ServerCalls.unaryServerMethodDefinition
import io.grpc.kotlin.StubFor
import kotlin.String
import kotlin.coroutines.CoroutineContext
import kotlin.coroutines.EmptyCoroutineContext
import kotlin.jvm.JvmOverloads
import kotlin.jvm.JvmStatic

/**
 * Holder for Kotlin coroutine-based client and server APIs for animals.Pig.
 */
public object PigGrpcKt {
  public const val SERVICE_NAME: String = PigGrpc.SERVICE_NAME

  @JvmStatic
  public val serviceDescriptor: ServiceDescriptor
    get() = PigGrpc.getServiceDescriptor()

  public val oinkMethod: MethodDescriptor<OinkRequest, OinkReply>
    @JvmStatic
    get() = PigGrpc.getOinkMethod()

  /**
   * A stub for issuing RPCs to a(n) animals.Pig service as suspending coroutines.
   */
  @StubFor(PigGrpc::class)
  public class PigCoroutineStub @JvmOverloads constructor(
    channel: Channel,
    callOptions: CallOptions = DEFAULT,
  ) : AbstractCoroutineStub<PigCoroutineStub>(channel, callOptions) {
    public override fun build(channel: Channel, callOptions: CallOptions): PigCoroutineStub =
        PigCoroutineStub(channel, callOptions)

    /**
     * Executes this RPC and returns the response message, suspending until the RPC completes
     * with [`Status.OK`][io.grpc.Status].  If the RPC completes with another status, a
     * corresponding
     * [StatusException] is thrown.  If this coroutine is cancelled, the RPC is also cancelled
     * with the corresponding exception as a cause.
     *
     * @param request The request message to send to the server.
     *
     * @param headers Metadata to attach to the request.  Most users will not need this.
     *
     * @return The single response from the server.
     */
    public suspend fun oink(request: OinkRequest, headers: Metadata = Metadata()): OinkReply =
        unaryRpc(
      channel,
      PigGrpc.getOinkMethod(),
      request,
      callOptions,
      headers
    )
  }

  /**
   * Skeletal implementation of the animals.Pig service based on Kotlin coroutines.
   */
  public abstract class PigCoroutineImplBase(
    coroutineContext: CoroutineContext = EmptyCoroutineContext,
  ) : AbstractCoroutineServerImpl(coroutineContext) {
    /**
     * Returns the response to an RPC for animals.Pig.Oink.
     *
     * If this method fails with a [StatusException], the RPC will fail with the corresponding
     * [io.grpc.Status].  If this method fails with a [java.util.concurrent.CancellationException],
     * the RPC will fail
     * with status `Status.CANCELLED`.  If this method fails for any other reason, the RPC will
     * fail with `Status.UNKNOWN` with the exception as a cause.
     *
     * @param request The request from the client.
     */
    public open suspend fun oink(request: OinkRequest): OinkReply = throw
        StatusException(UNIMPLEMENTED.withDescription("Method animals.Pig.Oink is unimplemented"))

    public final override fun bindService(): ServerServiceDefinition =
        builder(getServiceDescriptor())
      .addMethod(unaryServerMethodDefinition(
      context = this.context,
      descriptor = PigGrpc.getOinkMethod(),
      implementation = ::oink
    )).build()
  }
}
