//Generated by the protocol buffer compiler. DO NOT EDIT!
// source: io/grpc/examples/animals/pig.proto

package io.grpc.examples.animals;

@kotlin.jvm.JvmName("-initializeoinkRequest")
inline fun oinkRequest(block: io.grpc.examples.animals.OinkRequestKt.Dsl.() -> kotlin.Unit): io.grpc.examples.animals.OinkRequest =
  io.grpc.examples.animals.OinkRequestKt.Dsl._create(io.grpc.examples.animals.OinkRequest.newBuilder()).apply { block() }._build()
object OinkRequestKt {
  @kotlin.OptIn(com.google.protobuf.kotlin.OnlyForUseByGeneratedProtoCode::class)
  @com.google.protobuf.kotlin.ProtoDslMarker
  class Dsl private constructor(
    private val _builder: io.grpc.examples.animals.OinkRequest.Builder
  ) {
    companion object {
      @kotlin.jvm.JvmSynthetic
      @kotlin.PublishedApi
      internal fun _create(builder: io.grpc.examples.animals.OinkRequest.Builder): Dsl = Dsl(builder)
    }

    @kotlin.jvm.JvmSynthetic
    @kotlin.PublishedApi
    internal fun _build(): io.grpc.examples.animals.OinkRequest = _builder.build()
  }
}
@kotlin.jvm.JvmSynthetic
inline fun io.grpc.examples.animals.OinkRequest.copy(block: io.grpc.examples.animals.OinkRequestKt.Dsl.() -> kotlin.Unit): io.grpc.examples.animals.OinkRequest =
  io.grpc.examples.animals.OinkRequestKt.Dsl._create(this.toBuilder()).apply { block() }._build()
