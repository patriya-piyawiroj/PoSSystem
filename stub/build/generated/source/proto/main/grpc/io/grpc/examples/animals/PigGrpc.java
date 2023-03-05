package io.grpc.examples.animals;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.47.0)",
    comments = "Source: io/grpc/examples/animals/pig.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class PigGrpc {

  private PigGrpc() {}

  public static final String SERVICE_NAME = "animals.Pig";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<io.grpc.examples.animals.OinkRequest,
      io.grpc.examples.animals.OinkReply> getOinkMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "Oink",
      requestType = io.grpc.examples.animals.OinkRequest.class,
      responseType = io.grpc.examples.animals.OinkReply.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<io.grpc.examples.animals.OinkRequest,
      io.grpc.examples.animals.OinkReply> getOinkMethod() {
    io.grpc.MethodDescriptor<io.grpc.examples.animals.OinkRequest, io.grpc.examples.animals.OinkReply> getOinkMethod;
    if ((getOinkMethod = PigGrpc.getOinkMethod) == null) {
      synchronized (PigGrpc.class) {
        if ((getOinkMethod = PigGrpc.getOinkMethod) == null) {
          PigGrpc.getOinkMethod = getOinkMethod =
              io.grpc.MethodDescriptor.<io.grpc.examples.animals.OinkRequest, io.grpc.examples.animals.OinkReply>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "Oink"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  io.grpc.examples.animals.OinkRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  io.grpc.examples.animals.OinkReply.getDefaultInstance()))
              .setSchemaDescriptor(new PigMethodDescriptorSupplier("Oink"))
              .build();
        }
      }
    }
    return getOinkMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static PigStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<PigStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<PigStub>() {
        @java.lang.Override
        public PigStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new PigStub(channel, callOptions);
        }
      };
    return PigStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static PigBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<PigBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<PigBlockingStub>() {
        @java.lang.Override
        public PigBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new PigBlockingStub(channel, callOptions);
        }
      };
    return PigBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static PigFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<PigFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<PigFutureStub>() {
        @java.lang.Override
        public PigFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new PigFutureStub(channel, callOptions);
        }
      };
    return PigFutureStub.newStub(factory, channel);
  }

  /**
   */
  public static abstract class PigImplBase implements io.grpc.BindableService {

    /**
     */
    public void oink(io.grpc.examples.animals.OinkRequest request,
        io.grpc.stub.StreamObserver<io.grpc.examples.animals.OinkReply> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getOinkMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getOinkMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                io.grpc.examples.animals.OinkRequest,
                io.grpc.examples.animals.OinkReply>(
                  this, METHODID_OINK)))
          .build();
    }
  }

  /**
   */
  public static final class PigStub extends io.grpc.stub.AbstractAsyncStub<PigStub> {
    private PigStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected PigStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new PigStub(channel, callOptions);
    }

    /**
     */
    public void oink(io.grpc.examples.animals.OinkRequest request,
        io.grpc.stub.StreamObserver<io.grpc.examples.animals.OinkReply> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getOinkMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class PigBlockingStub extends io.grpc.stub.AbstractBlockingStub<PigBlockingStub> {
    private PigBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected PigBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new PigBlockingStub(channel, callOptions);
    }

    /**
     */
    public io.grpc.examples.animals.OinkReply oink(io.grpc.examples.animals.OinkRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getOinkMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class PigFutureStub extends io.grpc.stub.AbstractFutureStub<PigFutureStub> {
    private PigFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected PigFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new PigFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<io.grpc.examples.animals.OinkReply> oink(
        io.grpc.examples.animals.OinkRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getOinkMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_OINK = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final PigImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(PigImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_OINK:
          serviceImpl.oink((io.grpc.examples.animals.OinkRequest) request,
              (io.grpc.stub.StreamObserver<io.grpc.examples.animals.OinkReply>) responseObserver);
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

  private static abstract class PigBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    PigBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return io.grpc.examples.animals.PigProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("Pig");
    }
  }

  private static final class PigFileDescriptorSupplier
      extends PigBaseDescriptorSupplier {
    PigFileDescriptorSupplier() {}
  }

  private static final class PigMethodDescriptorSupplier
      extends PigBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    PigMethodDescriptorSupplier(String methodName) {
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
      synchronized (PigGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new PigFileDescriptorSupplier())
              .addMethod(getOinkMethod())
              .build();
        }
      }
    }
    return result;
  }
}
