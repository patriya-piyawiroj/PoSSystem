//Generated by the protocol buffer compiler. DO NOT EDIT!
// source: io/grpc/examples/animals/dog.proto

package io.grpc.examples.animals;

@kotlin.jvm.JvmName("-initializebarkReply")
inline fun barkReply(block: io.grpc.examples.animals.BarkReplyKt.Dsl.() -> kotlin.Unit): io.grpc.examples.animals.BarkReply =
  io.grpc.examples.animals.BarkReplyKt.Dsl._create(io.grpc.examples.animals.BarkReply.newBuilder()).apply { block() }._build()
object BarkReplyKt {
  @kotlin.OptIn(com.google.protobuf.kotlin.OnlyForUseByGeneratedProtoCode::class)
  @com.google.protobuf.kotlin.ProtoDslMarker
  class Dsl private constructor(
    private val _builder: io.grpc.examples.animals.BarkReply.Builder
  ) {
    companion object {
      @kotlin.jvm.JvmSynthetic
      @kotlin.PublishedApi
      internal fun _create(builder: io.grpc.examples.animals.BarkReply.Builder): Dsl = Dsl(builder)
    }

    @kotlin.jvm.JvmSynthetic
    @kotlin.PublishedApi
    internal fun _build(): io.grpc.examples.animals.BarkReply = _builder.build()

    /**
     * <code>string message = 1;</code>
     */
    var message: kotlin.String
      @JvmName("getMessage")
      get() = _builder.getMessage()
      @JvmName("setMessage")
      set(value) {
        _builder.setMessage(value)
      }
    /**
     * <code>string message = 1;</code>
     */
    fun clearMessage() {
      _builder.clearMessage()
    }
  }
}
@kotlin.jvm.JvmSynthetic
inline fun io.grpc.examples.animals.BarkReply.copy(block: io.grpc.examples.animals.BarkReplyKt.Dsl.() -> kotlin.Unit): io.grpc.examples.animals.BarkReply =
  io.grpc.examples.animals.BarkReplyKt.Dsl._create(this.toBuilder()).apply { block() }._build()
