//Generated by the protocol buffer compiler. DO NOT EDIT!
// source: io/grpc/examples/animals/dog.proto

package io.grpc.examples.animals;

@kotlin.jvm.JvmName("-initializebarkRequest")
inline fun barkRequest(block: io.grpc.examples.animals.BarkRequestKt.Dsl.() -> kotlin.Unit): io.grpc.examples.animals.BarkRequest =
  io.grpc.examples.animals.BarkRequestKt.Dsl._create(io.grpc.examples.animals.BarkRequest.newBuilder()).apply { block() }._build()
object BarkRequestKt {
  @kotlin.OptIn(com.google.protobuf.kotlin.OnlyForUseByGeneratedProtoCode::class)
  @com.google.protobuf.kotlin.ProtoDslMarker
  class Dsl private constructor(
    private val _builder: io.grpc.examples.animals.BarkRequest.Builder
  ) {
    companion object {
      @kotlin.jvm.JvmSynthetic
      @kotlin.PublishedApi
      internal fun _create(builder: io.grpc.examples.animals.BarkRequest.Builder): Dsl = Dsl(builder)
    }

    @kotlin.jvm.JvmSynthetic
    @kotlin.PublishedApi
    internal fun _build(): io.grpc.examples.animals.BarkRequest = _builder.build()
  }
}
@kotlin.jvm.JvmSynthetic
inline fun io.grpc.examples.animals.BarkRequest.copy(block: io.grpc.examples.animals.BarkRequestKt.Dsl.() -> kotlin.Unit): io.grpc.examples.animals.BarkRequest =
  io.grpc.examples.animals.BarkRequestKt.Dsl._create(this.toBuilder()).apply { block() }._build()
