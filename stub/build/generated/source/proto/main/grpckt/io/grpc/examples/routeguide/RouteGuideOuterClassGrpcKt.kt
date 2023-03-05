package io.grpc.examples.routeguide

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
import io.grpc.examples.routeguide.RouteGuideGrpc.getServiceDescriptor
import io.grpc.kotlin.AbstractCoroutineServerImpl
import io.grpc.kotlin.AbstractCoroutineStub
import io.grpc.kotlin.ClientCalls.bidiStreamingRpc
import io.grpc.kotlin.ClientCalls.clientStreamingRpc
import io.grpc.kotlin.ClientCalls.serverStreamingRpc
import io.grpc.kotlin.ClientCalls.unaryRpc
import io.grpc.kotlin.ServerCalls.bidiStreamingServerMethodDefinition
import io.grpc.kotlin.ServerCalls.clientStreamingServerMethodDefinition
import io.grpc.kotlin.ServerCalls.serverStreamingServerMethodDefinition
import io.grpc.kotlin.ServerCalls.unaryServerMethodDefinition
import io.grpc.kotlin.StubFor
import kotlin.String
import kotlin.coroutines.CoroutineContext
import kotlin.coroutines.EmptyCoroutineContext
import kotlin.jvm.JvmOverloads
import kotlin.jvm.JvmStatic
import kotlinx.coroutines.flow.Flow

/**
 * Holder for Kotlin coroutine-based client and server APIs for
 * io.grpc.examples.routeguide.RouteGuide.
 */
public object RouteGuideGrpcKt {
  public const val SERVICE_NAME: String = RouteGuideGrpc.SERVICE_NAME

  @JvmStatic
  public val serviceDescriptor: ServiceDescriptor
    get() = RouteGuideGrpc.getServiceDescriptor()

  public val getFeatureMethod: MethodDescriptor<Point, Feature>
    @JvmStatic
    get() = RouteGuideGrpc.getGetFeatureMethod()

  public val listFeaturesMethod: MethodDescriptor<Rectangle, Feature>
    @JvmStatic
    get() = RouteGuideGrpc.getListFeaturesMethod()

  public val recordRouteMethod: MethodDescriptor<Point, RouteSummary>
    @JvmStatic
    get() = RouteGuideGrpc.getRecordRouteMethod()

  public val routeChatMethod: MethodDescriptor<RouteNote, RouteNote>
    @JvmStatic
    get() = RouteGuideGrpc.getRouteChatMethod()

  /**
   * A stub for issuing RPCs to a(n) io.grpc.examples.routeguide.RouteGuide service as suspending
   * coroutines.
   */
  @StubFor(RouteGuideGrpc::class)
  public class RouteGuideCoroutineStub @JvmOverloads constructor(
    channel: Channel,
    callOptions: CallOptions = DEFAULT,
  ) : AbstractCoroutineStub<RouteGuideCoroutineStub>(channel, callOptions) {
    public override fun build(channel: Channel, callOptions: CallOptions): RouteGuideCoroutineStub =
        RouteGuideCoroutineStub(channel, callOptions)

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
    public suspend fun getFeature(request: Point, headers: Metadata = Metadata()): Feature =
        unaryRpc(
      channel,
      RouteGuideGrpc.getGetFeatureMethod(),
      request,
      callOptions,
      headers
    )

    /**
     * Returns a [Flow] that, when collected, executes this RPC and emits responses from the
     * server as they arrive.  That flow finishes normally if the server closes its response with
     * [`Status.OK`][Status], and fails by throwing a [StatusException] otherwise.  If
     * collecting the flow downstream fails exceptionally (including via cancellation), the RPC
     * is cancelled with that exception as a cause.
     *
     * @param request The request message to send to the server.
     *
     * @param headers Metadata to attach to the request.  Most users will not need this.
     *
     * @return A flow that, when collected, emits the responses from the server.
     */
    public fun listFeatures(request: Rectangle, headers: Metadata = Metadata()): Flow<Feature> =
        serverStreamingRpc(
      channel,
      RouteGuideGrpc.getListFeaturesMethod(),
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
     * This function collects the [Flow] of requests.  If the server terminates the RPC
     * for any reason before collection of requests is complete, the collection of requests
     * will be cancelled.  If the collection of requests completes exceptionally for any other
     * reason, the RPC will be cancelled for that reason and this method will throw that
     * exception.
     *
     * @param requests A [Flow] of request messages.
     *
     * @param headers Metadata to attach to the request.  Most users will not need this.
     *
     * @return The single response from the server.
     */
    public suspend fun recordRoute(requests: Flow<Point>, headers: Metadata = Metadata()):
        RouteSummary = clientStreamingRpc(
      channel,
      RouteGuideGrpc.getRecordRouteMethod(),
      requests,
      callOptions,
      headers
    )

    /**
     * Returns a [Flow] that, when collected, executes this RPC and emits responses from the
     * server as they arrive.  That flow finishes normally if the server closes its response with
     * [`Status.OK`][Status], and fails by throwing a [StatusException] otherwise.  If
     * collecting the flow downstream fails exceptionally (including via cancellation), the RPC
     * is cancelled with that exception as a cause.
     *
     * The [Flow] of requests is collected once each time the [Flow] of responses is
     * collected. If collection of the [Flow] of responses completes normally or
     * exceptionally before collection of `requests` completes, the collection of
     * `requests` is cancelled.  If the collection of `requests` completes
     * exceptionally for any other reason, then the collection of the [Flow] of responses
     * completes exceptionally for the same reason and the RPC is cancelled with that reason.
     *
     * @param requests A [Flow] of request messages.
     *
     * @param headers Metadata to attach to the request.  Most users will not need this.
     *
     * @return A flow that, when collected, emits the responses from the server.
     */
    public fun routeChat(requests: Flow<RouteNote>, headers: Metadata = Metadata()): Flow<RouteNote>
        = bidiStreamingRpc(
      channel,
      RouteGuideGrpc.getRouteChatMethod(),
      requests,
      callOptions,
      headers
    )
  }

  /**
   * Skeletal implementation of the io.grpc.examples.routeguide.RouteGuide service based on Kotlin
   * coroutines.
   */
  public abstract class RouteGuideCoroutineImplBase(
    coroutineContext: CoroutineContext = EmptyCoroutineContext,
  ) : AbstractCoroutineServerImpl(coroutineContext) {
    /**
     * Returns the response to an RPC for io.grpc.examples.routeguide.RouteGuide.GetFeature.
     *
     * If this method fails with a [StatusException], the RPC will fail with the corresponding
     * [Status].  If this method fails with a [java.util.concurrent.CancellationException], the RPC
     * will fail
     * with status `Status.CANCELLED`.  If this method fails for any other reason, the RPC will
     * fail with `Status.UNKNOWN` with the exception as a cause.
     *
     * @param request The request from the client.
     */
    public open suspend fun getFeature(request: Point): Feature = throw
        StatusException(UNIMPLEMENTED.withDescription("Method io.grpc.examples.routeguide.RouteGuide.GetFeature is unimplemented"))

    /**
     * Returns a [Flow] of responses to an RPC for
     * io.grpc.examples.routeguide.RouteGuide.ListFeatures.
     *
     * If creating or collecting the returned flow fails with a [StatusException], the RPC
     * will fail with the corresponding [Status].  If it fails with a
     * [java.util.concurrent.CancellationException], the RPC will fail with status
     * `Status.CANCELLED`.  If creating
     * or collecting the returned flow fails for any other reason, the RPC will fail with
     * `Status.UNKNOWN` with the exception as a cause.
     *
     * @param request The request from the client.
     */
    public open fun listFeatures(request: Rectangle): Flow<Feature> = throw
        StatusException(UNIMPLEMENTED.withDescription("Method io.grpc.examples.routeguide.RouteGuide.ListFeatures is unimplemented"))

    /**
     * Returns the response to an RPC for io.grpc.examples.routeguide.RouteGuide.RecordRoute.
     *
     * If this method fails with a [StatusException], the RPC will fail with the corresponding
     * [Status].  If this method fails with a [java.util.concurrent.CancellationException], the RPC
     * will fail
     * with status `Status.CANCELLED`.  If this method fails for any other reason, the RPC will
     * fail with `Status.UNKNOWN` with the exception as a cause.
     *
     * @param requests A [Flow] of requests from the client.  This flow can be
     *        collected only once and throws [java.lang.IllegalStateException] on attempts to
     * collect
     *        it more than once.
     */
    public open suspend fun recordRoute(requests: Flow<Point>): RouteSummary = throw
        StatusException(UNIMPLEMENTED.withDescription("Method io.grpc.examples.routeguide.RouteGuide.RecordRoute is unimplemented"))

    /**
     * Returns a [Flow] of responses to an RPC for io.grpc.examples.routeguide.RouteGuide.RouteChat.
     *
     * If creating or collecting the returned flow fails with a [StatusException], the RPC
     * will fail with the corresponding [Status].  If it fails with a
     * [java.util.concurrent.CancellationException], the RPC will fail with status
     * `Status.CANCELLED`.  If creating
     * or collecting the returned flow fails for any other reason, the RPC will fail with
     * `Status.UNKNOWN` with the exception as a cause.
     *
     * @param requests A [Flow] of requests from the client.  This flow can be
     *        collected only once and throws [java.lang.IllegalStateException] on attempts to
     * collect
     *        it more than once.
     */
    public open fun routeChat(requests: Flow<RouteNote>): Flow<RouteNote> = throw
        StatusException(UNIMPLEMENTED.withDescription("Method io.grpc.examples.routeguide.RouteGuide.RouteChat is unimplemented"))

    public final override fun bindService(): ServerServiceDefinition =
        builder(getServiceDescriptor())
      .addMethod(unaryServerMethodDefinition(
      context = this.context,
      descriptor = RouteGuideGrpc.getGetFeatureMethod(),
      implementation = ::getFeature
    ))
      .addMethod(serverStreamingServerMethodDefinition(
      context = this.context,
      descriptor = RouteGuideGrpc.getListFeaturesMethod(),
      implementation = ::listFeatures
    ))
      .addMethod(clientStreamingServerMethodDefinition(
      context = this.context,
      descriptor = RouteGuideGrpc.getRecordRouteMethod(),
      implementation = ::recordRoute
    ))
      .addMethod(bidiStreamingServerMethodDefinition(
      context = this.context,
      descriptor = RouteGuideGrpc.getRouteChatMethod(),
      implementation = ::routeChat
    )).build()
  }
}
