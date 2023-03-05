package io.grpc.examples.animals;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.47.0)",
    comments = "Source: io/grpc/examples/animals/sheep.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class SheepGrpc {

  private SheepGrpc() {}

  public static final String SERVICE_NAME = "animals.Sheep";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<io.grpc.examples.animals.BaaRequest,
      io.grpc.examples.animals.BaaReply> getBaaMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "Baa",
      requestType = io.grpc.examples.animals.BaaRequest.class,
      responseType = io.grpc.examples.animals.BaaReply.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<io.grpc.examples.animals.BaaRequest,
      io.grpc.examples.animals.BaaReply> getBaaMethod() {
    io.grpc.MethodDescriptor<io.grpc.examples.animals.BaaRequest, io.grpc.examples.animals.BaaReply> getBaaMethod;
    if ((getBaaMethod = SheepGrpc.getBaaMethod) == null) {
      synchronized (SheepGrpc.class) {
        if ((getBaaMethod = SheepGrpc.getBaaMethod) == null) {
          SheepGrpc.getBaaMethod = getBaaMethod =
              io.grpc.MethodDescriptor.<io.grpc.examples.animals.BaaRequest, io.grpc.examples.animals.BaaReply>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "Baa"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  io.grpc.examples.animals.BaaRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  io.grpc.examples.animals.BaaReply.getDefaultInstance()))
              .setSchemaDescriptor(new SheepMethodDescriptorSupplier("Baa"))
              .build();
        }
      }
    }
    return getBaaMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static SheepStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<SheepStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<SheepStub>() {
        @java.lang.Override
        public SheepStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new SheepStub(channel, callOptions);
        }
      };
    return SheepStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static SheepBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<SheepBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<SheepBlockingStub>() {
        @java.lang.Override
        public SheepBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new SheepBlockingStub(channel, callOptions);
        }
      };
    return SheepBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static SheepFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<SheepFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<SheepFutureStub>() {
        @java.lang.Override
        public SheepFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new SheepFutureStub(channel, callOptions);
        }
      };
    return SheepFutureStub.newStub(factory, channel);
  }

  /**
   */
  public static abstract class SheepImplBase implements io.grpc.BindableService {

    /**
     */
    public void baa(io.grpc.examples.animals.BaaRequest request,
        io.grpc.stub.StreamObserver<io.grpc.examples.animals.BaaReply> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getBaaMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getBaaMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                io.grpc.examples.animals.BaaRequest,
                io.grpc.examples.animals.BaaReply>(
                  this, METHODID_BAA)))
          .build();
    }
  }

  /**
   */
  public static final class SheepStub extends io.grpc.stub.AbstractAsyncStub<SheepStub> {
    private SheepStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SheepStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new SheepStub(channel, callOptions);
    }

    /**
     */
    public void baa(io.grpc.examples.animals.BaaRequest request,
        io.grpc.stub.StreamObserver<io.grpc.examples.animals.BaaReply> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getBaaMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class SheepBlockingStub extends io.grpc.stub.AbstractBlockingStub<SheepBlockingStub> {
    private SheepBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SheepBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new SheepBlockingStub(channel, callOptions);
    }

    /**
     */
    public io.grpc.examples.animals.BaaReply baa(io.grpc.examples.animals.BaaRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getBaaMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class SheepFutureStub extends io.grpc.stub.AbstractFutureStub<SheepFutureStub> {
    private SheepFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SheepFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new SheepFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<io.grpc.examples.animals.BaaReply> baa(
        io.grpc.examples.animals.BaaRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getBaaMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_BAA = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final SheepImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(SheepImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_BAA:
          serviceImpl.baa((io.grpc.examples.animals.BaaRequest) request,
              (io.grpc.stub.StreamObserver<io.grpc.examples.animals.BaaReply>) responseObserver);
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

  private static abstract class SheepBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    SheepBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return io.grpc.examples.animals.SheepProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("Sheep");
    }
  }

  private static final class SheepFileDescriptorSupplier
      extends SheepBaseDescriptorSupplier {
    SheepFileDescriptorSupplier() {}
  }

  private static final class SheepMethodDescriptorSupplier
      extends SheepBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    SheepMethodDescriptorSupplier(String methodName) {
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
      synchronized (SheepGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new SheepFileDescriptorSupplier())
              .addMethod(getBaaMethod())
              .build();
        }
      }
    }
    return result;
  }
}
