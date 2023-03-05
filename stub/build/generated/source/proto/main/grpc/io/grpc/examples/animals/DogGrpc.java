package io.grpc.examples.animals;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.47.0)",
    comments = "Source: io/grpc/examples/animals/dog.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class DogGrpc {

  private DogGrpc() {}

  public static final String SERVICE_NAME = "animals.Dog";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<io.grpc.examples.animals.BarkRequest,
      io.grpc.examples.animals.BarkReply> getBarkMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "Bark",
      requestType = io.grpc.examples.animals.BarkRequest.class,
      responseType = io.grpc.examples.animals.BarkReply.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<io.grpc.examples.animals.BarkRequest,
      io.grpc.examples.animals.BarkReply> getBarkMethod() {
    io.grpc.MethodDescriptor<io.grpc.examples.animals.BarkRequest, io.grpc.examples.animals.BarkReply> getBarkMethod;
    if ((getBarkMethod = DogGrpc.getBarkMethod) == null) {
      synchronized (DogGrpc.class) {
        if ((getBarkMethod = DogGrpc.getBarkMethod) == null) {
          DogGrpc.getBarkMethod = getBarkMethod =
              io.grpc.MethodDescriptor.<io.grpc.examples.animals.BarkRequest, io.grpc.examples.animals.BarkReply>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "Bark"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  io.grpc.examples.animals.BarkRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  io.grpc.examples.animals.BarkReply.getDefaultInstance()))
              .setSchemaDescriptor(new DogMethodDescriptorSupplier("Bark"))
              .build();
        }
      }
    }
    return getBarkMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static DogStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<DogStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<DogStub>() {
        @java.lang.Override
        public DogStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new DogStub(channel, callOptions);
        }
      };
    return DogStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static DogBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<DogBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<DogBlockingStub>() {
        @java.lang.Override
        public DogBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new DogBlockingStub(channel, callOptions);
        }
      };
    return DogBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static DogFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<DogFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<DogFutureStub>() {
        @java.lang.Override
        public DogFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new DogFutureStub(channel, callOptions);
        }
      };
    return DogFutureStub.newStub(factory, channel);
  }

  /**
   */
  public static abstract class DogImplBase implements io.grpc.BindableService {

    /**
     */
    public void bark(io.grpc.examples.animals.BarkRequest request,
        io.grpc.stub.StreamObserver<io.grpc.examples.animals.BarkReply> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getBarkMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getBarkMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                io.grpc.examples.animals.BarkRequest,
                io.grpc.examples.animals.BarkReply>(
                  this, METHODID_BARK)))
          .build();
    }
  }

  /**
   */
  public static final class DogStub extends io.grpc.stub.AbstractAsyncStub<DogStub> {
    private DogStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected DogStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new DogStub(channel, callOptions);
    }

    /**
     */
    public void bark(io.grpc.examples.animals.BarkRequest request,
        io.grpc.stub.StreamObserver<io.grpc.examples.animals.BarkReply> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getBarkMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class DogBlockingStub extends io.grpc.stub.AbstractBlockingStub<DogBlockingStub> {
    private DogBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected DogBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new DogBlockingStub(channel, callOptions);
    }

    /**
     */
    public io.grpc.examples.animals.BarkReply bark(io.grpc.examples.animals.BarkRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getBarkMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class DogFutureStub extends io.grpc.stub.AbstractFutureStub<DogFutureStub> {
    private DogFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected DogFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new DogFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<io.grpc.examples.animals.BarkReply> bark(
        io.grpc.examples.animals.BarkRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getBarkMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_BARK = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final DogImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(DogImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_BARK:
          serviceImpl.bark((io.grpc.examples.animals.BarkRequest) request,
              (io.grpc.stub.StreamObserver<io.grpc.examples.animals.BarkReply>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class DogBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    DogBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return io.grpc.examples.animals.DogProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("Dog");
    }
  }

  private static final class DogFileDescriptorSupplier
      extends DogBaseDescriptorSupplier {
    DogFileDescriptorSupplier() {}
  }

  private static final class DogMethodDescriptorSupplier
      extends DogBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    DogMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (DogGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new DogFileDescriptorSupplier())
              .addMethod(getBarkMethod())
              .build();
        }
      }
    }
    return result;
  }
}
