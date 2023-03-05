//Generated by the protocol buffer compiler. DO NOT EDIT!
// source: io/grpc/examples/routeguide/route_guide.proto

package io.grpc.examples.routeguide;

@kotlin.jvm.JvmName("-initializefeature")
inline fun feature(block: io.grpc.examples.routeguide.FeatureKt.Dsl.() -> kotlin.Unit): io.grpc.examples.routeguide.Feature =
  io.grpc.examples.routeguide.FeatureKt.Dsl._create(io.grpc.examples.routeguide.Feature.newBuilder()).apply { block() }._build()
object FeatureKt {
  @kotlin.OptIn(com.google.protobuf.kotlin.OnlyForUseByGeneratedProtoCode::class)
  @com.google.protobuf.kotlin.ProtoDslMarker
  class Dsl private constructor(
    private val _builder: io.grpc.examples.routeguide.Feature.Builder
  ) {
    companion object {
      @kotlin.jvm.JvmSynthetic
      @kotlin.PublishedApi
      internal fun _create(builder: io.grpc.examples.routeguide.Feature.Builder): Dsl = Dsl(builder)
    }

    @kotlin.jvm.JvmSynthetic
    @kotlin.PublishedApi
    internal fun _build(): io.grpc.examples.routeguide.Feature = _builder.build()

    /**
     * <pre>
     * The name of the feature.
     * </pre>
     *
     * <code>string name = 1;</code>
     */
    var name: kotlin.String
      @JvmName("getName")
      get() = _builder.getName()
      @JvmName("setName")
      set(value) {
        _builder.setName(value)
      }
    /**
     * <pre>
     * The name of the feature.
     * </pre>
     *
     * <code>string name = 1;</code>
     */
    fun clearName() {
      _builder.clearName()
    }

    /**
     * <pre>
     * The point where the feature is detected.
     * </pre>
     *
     * <code>.io.grpc.examples.routeguide.Point location = 2;</code>
     */
    var location: io.grpc.examples.routeguide.Point
      @JvmName("getLocation")
      get() = _builder.getLocation()
      @JvmName("setLocation")
      set(value) {
        _builder.setLocation(value)
      }
    /**
     * <pre>
     * The point where the feature is detected.
     * </pre>
     *
     * <code>.io.grpc.examples.routeguide.Point location = 2;</code>
     */
    fun clearLocation() {
      _builder.clearLocation()
    }
    /**
     * <pre>
     * The point where the feature is detected.
     * </pre>
     *
     * <code>.io.grpc.examples.routeguide.Point location = 2;</code>
     * @return Whether the location field is set.
     */
    fun hasLocation(): kotlin.Boolean {
      return _builder.hasLocation()
    }
  }
}
@kotlin.jvm.JvmSynthetic
inline fun io.grpc.examples.routeguide.Feature.copy(block: io.grpc.examples.routeguide.FeatureKt.Dsl.() -> kotlin.Unit): io.grpc.examples.routeguide.Feature =
  io.grpc.examples.routeguide.FeatureKt.Dsl._create(this.toBuilder()).apply { block() }._build()

val io.grpc.examples.routeguide.FeatureOrBuilder.locationOrNull: io.grpc.examples.routeguide.Point?
  get() = if (hasLocation()) getLocation() else null

