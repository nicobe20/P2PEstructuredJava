package com.example.p2pnetwork;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.40.1)",
    comments = "Source: p2p.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class P2PServiceGrpc {

  private P2PServiceGrpc() {}

  public static final String SERVICE_NAME = "P2PService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.example.p2pnetwork.P2PServiceProto.FileTransferRequest,
      com.example.p2pnetwork.P2PServiceProto.FileTransferResponse> getSimulateFileTransferMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "simulateFileTransfer",
      requestType = com.example.p2pnetwork.P2PServiceProto.FileTransferRequest.class,
      responseType = com.example.p2pnetwork.P2PServiceProto.FileTransferResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.example.p2pnetwork.P2PServiceProto.FileTransferRequest,
      com.example.p2pnetwork.P2PServiceProto.FileTransferResponse> getSimulateFileTransferMethod() {
    io.grpc.MethodDescriptor<com.example.p2pnetwork.P2PServiceProto.FileTransferRequest, com.example.p2pnetwork.P2PServiceProto.FileTransferResponse> getSimulateFileTransferMethod;
    if ((getSimulateFileTransferMethod = P2PServiceGrpc.getSimulateFileTransferMethod) == null) {
      synchronized (P2PServiceGrpc.class) {
        if ((getSimulateFileTransferMethod = P2PServiceGrpc.getSimulateFileTransferMethod) == null) {
          P2PServiceGrpc.getSimulateFileTransferMethod = getSimulateFileTransferMethod =
              io.grpc.MethodDescriptor.<com.example.p2pnetwork.P2PServiceProto.FileTransferRequest, com.example.p2pnetwork.P2PServiceProto.FileTransferResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "simulateFileTransfer"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.p2pnetwork.P2PServiceProto.FileTransferRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.p2pnetwork.P2PServiceProto.FileTransferResponse.getDefaultInstance()))
              .setSchemaDescriptor(new P2PServiceMethodDescriptorSupplier("simulateFileTransfer"))
              .build();
        }
      }
    }
    return getSimulateFileTransferMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static P2PServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<P2PServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<P2PServiceStub>() {
        @java.lang.Override
        public P2PServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new P2PServiceStub(channel, callOptions);
        }
      };
    return P2PServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static P2PServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<P2PServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<P2PServiceBlockingStub>() {
        @java.lang.Override
        public P2PServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new P2PServiceBlockingStub(channel, callOptions);
        }
      };
    return P2PServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static P2PServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<P2PServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<P2PServiceFutureStub>() {
        @java.lang.Override
        public P2PServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new P2PServiceFutureStub(channel, callOptions);
        }
      };
    return P2PServiceFutureStub.newStub(factory, channel);
  }

  /**
   */
  public static abstract class P2PServiceImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     * RPC to simulate file transfer
     * </pre>
     */
    public void simulateFileTransfer(com.example.p2pnetwork.P2PServiceProto.FileTransferRequest request,
        io.grpc.stub.StreamObserver<com.example.p2pnetwork.P2PServiceProto.FileTransferResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getSimulateFileTransferMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getSimulateFileTransferMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.example.p2pnetwork.P2PServiceProto.FileTransferRequest,
                com.example.p2pnetwork.P2PServiceProto.FileTransferResponse>(
                  this, METHODID_SIMULATE_FILE_TRANSFER)))
          .build();
    }
  }

  /**
   */
  public static final class P2PServiceStub extends io.grpc.stub.AbstractAsyncStub<P2PServiceStub> {
    private P2PServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected P2PServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new P2PServiceStub(channel, callOptions);
    }

    /**
     * <pre>
     * RPC to simulate file transfer
     * </pre>
     */
    public void simulateFileTransfer(com.example.p2pnetwork.P2PServiceProto.FileTransferRequest request,
        io.grpc.stub.StreamObserver<com.example.p2pnetwork.P2PServiceProto.FileTransferResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getSimulateFileTransferMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class P2PServiceBlockingStub extends io.grpc.stub.AbstractBlockingStub<P2PServiceBlockingStub> {
    private P2PServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected P2PServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new P2PServiceBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * RPC to simulate file transfer
     * </pre>
     */
    public com.example.p2pnetwork.P2PServiceProto.FileTransferResponse simulateFileTransfer(com.example.p2pnetwork.P2PServiceProto.FileTransferRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getSimulateFileTransferMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class P2PServiceFutureStub extends io.grpc.stub.AbstractFutureStub<P2PServiceFutureStub> {
    private P2PServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected P2PServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new P2PServiceFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     * RPC to simulate file transfer
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.example.p2pnetwork.P2PServiceProto.FileTransferResponse> simulateFileTransfer(
        com.example.p2pnetwork.P2PServiceProto.FileTransferRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getSimulateFileTransferMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_SIMULATE_FILE_TRANSFER = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final P2PServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(P2PServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_SIMULATE_FILE_TRANSFER:
          serviceImpl.simulateFileTransfer((com.example.p2pnetwork.P2PServiceProto.FileTransferRequest) request,
              (io.grpc.stub.StreamObserver<com.example.p2pnetwork.P2PServiceProto.FileTransferResponse>) responseObserver);
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

  private static abstract class P2PServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    P2PServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.example.p2pnetwork.P2PServiceProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("P2PService");
    }
  }

  private static final class P2PServiceFileDescriptorSupplier
      extends P2PServiceBaseDescriptorSupplier {
    P2PServiceFileDescriptorSupplier() {}
  }

  private static final class P2PServiceMethodDescriptorSupplier
      extends P2PServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    P2PServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (P2PServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new P2PServiceFileDescriptorSupplier())
              .addMethod(getSimulateFileTransferMethod())
              .build();
        }
      }
    }
    return result;
  }
}
