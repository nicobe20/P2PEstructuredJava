package com.example.p2pnetwork;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 * <pre>
 * gRPC Service definition
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.40.1)",
    comments = "Source: p2p.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class P2PServiceGrpc {

  private P2PServiceGrpc() {}

  public static final String SERVICE_NAME = "P2PService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.example.p2pnetwork.P2PServiceProto.PingRequest,
      com.example.p2pnetwork.P2PServiceProto.PingResponse> getPingMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ping",
      requestType = com.example.p2pnetwork.P2PServiceProto.PingRequest.class,
      responseType = com.example.p2pnetwork.P2PServiceProto.PingResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.example.p2pnetwork.P2PServiceProto.PingRequest,
      com.example.p2pnetwork.P2PServiceProto.PingResponse> getPingMethod() {
    io.grpc.MethodDescriptor<com.example.p2pnetwork.P2PServiceProto.PingRequest, com.example.p2pnetwork.P2PServiceProto.PingResponse> getPingMethod;
    if ((getPingMethod = P2PServiceGrpc.getPingMethod) == null) {
      synchronized (P2PServiceGrpc.class) {
        if ((getPingMethod = P2PServiceGrpc.getPingMethod) == null) {
          P2PServiceGrpc.getPingMethod = getPingMethod =
              io.grpc.MethodDescriptor.<com.example.p2pnetwork.P2PServiceProto.PingRequest, com.example.p2pnetwork.P2PServiceProto.PingResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ping"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.p2pnetwork.P2PServiceProto.PingRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.p2pnetwork.P2PServiceProto.PingResponse.getDefaultInstance()))
              .setSchemaDescriptor(new P2PServiceMethodDescriptorSupplier("ping"))
              .build();
        }
      }
    }
    return getPingMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.example.p2pnetwork.P2PServiceProto.NodeInfoRequest,
      com.example.p2pnetwork.P2PServiceProto.NodeInfoResponse> getGetNodeInfoMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "getNodeInfo",
      requestType = com.example.p2pnetwork.P2PServiceProto.NodeInfoRequest.class,
      responseType = com.example.p2pnetwork.P2PServiceProto.NodeInfoResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.example.p2pnetwork.P2PServiceProto.NodeInfoRequest,
      com.example.p2pnetwork.P2PServiceProto.NodeInfoResponse> getGetNodeInfoMethod() {
    io.grpc.MethodDescriptor<com.example.p2pnetwork.P2PServiceProto.NodeInfoRequest, com.example.p2pnetwork.P2PServiceProto.NodeInfoResponse> getGetNodeInfoMethod;
    if ((getGetNodeInfoMethod = P2PServiceGrpc.getGetNodeInfoMethod) == null) {
      synchronized (P2PServiceGrpc.class) {
        if ((getGetNodeInfoMethod = P2PServiceGrpc.getGetNodeInfoMethod) == null) {
          P2PServiceGrpc.getGetNodeInfoMethod = getGetNodeInfoMethod =
              io.grpc.MethodDescriptor.<com.example.p2pnetwork.P2PServiceProto.NodeInfoRequest, com.example.p2pnetwork.P2PServiceProto.NodeInfoResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "getNodeInfo"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.p2pnetwork.P2PServiceProto.NodeInfoRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.p2pnetwork.P2PServiceProto.NodeInfoResponse.getDefaultInstance()))
              .setSchemaDescriptor(new P2PServiceMethodDescriptorSupplier("getNodeInfo"))
              .build();
        }
      }
    }
    return getGetNodeInfoMethod;
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
   * <pre>
   * gRPC Service definition
   * </pre>
   */
  public static abstract class P2PServiceImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     * RPC para simular el ping entre nodos
     * </pre>
     */
    public void ping(com.example.p2pnetwork.P2PServiceProto.PingRequest request,
        io.grpc.stub.StreamObserver<com.example.p2pnetwork.P2PServiceProto.PingResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getPingMethod(), responseObserver);
    }

    /**
     * <pre>
     * RPC para obtener la información de un nodo
     * </pre>
     */
    public void getNodeInfo(com.example.p2pnetwork.P2PServiceProto.NodeInfoRequest request,
        io.grpc.stub.StreamObserver<com.example.p2pnetwork.P2PServiceProto.NodeInfoResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetNodeInfoMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getPingMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.example.p2pnetwork.P2PServiceProto.PingRequest,
                com.example.p2pnetwork.P2PServiceProto.PingResponse>(
                  this, METHODID_PING)))
          .addMethod(
            getGetNodeInfoMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.example.p2pnetwork.P2PServiceProto.NodeInfoRequest,
                com.example.p2pnetwork.P2PServiceProto.NodeInfoResponse>(
                  this, METHODID_GET_NODE_INFO)))
          .build();
    }
  }

  /**
   * <pre>
   * gRPC Service definition
   * </pre>
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
     * RPC para simular el ping entre nodos
     * </pre>
     */
    public void ping(com.example.p2pnetwork.P2PServiceProto.PingRequest request,
        io.grpc.stub.StreamObserver<com.example.p2pnetwork.P2PServiceProto.PingResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getPingMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * RPC para obtener la información de un nodo
     * </pre>
     */
    public void getNodeInfo(com.example.p2pnetwork.P2PServiceProto.NodeInfoRequest request,
        io.grpc.stub.StreamObserver<com.example.p2pnetwork.P2PServiceProto.NodeInfoResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetNodeInfoMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * <pre>
   * gRPC Service definition
   * </pre>
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
     * RPC para simular el ping entre nodos
     * </pre>
     */
    public com.example.p2pnetwork.P2PServiceProto.PingResponse ping(com.example.p2pnetwork.P2PServiceProto.PingRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getPingMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * RPC para obtener la información de un nodo
     * </pre>
     */
    public com.example.p2pnetwork.P2PServiceProto.NodeInfoResponse getNodeInfo(com.example.p2pnetwork.P2PServiceProto.NodeInfoRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetNodeInfoMethod(), getCallOptions(), request);
    }
  }

  /**
   * <pre>
   * gRPC Service definition
   * </pre>
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
     * RPC para simular el ping entre nodos
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.example.p2pnetwork.P2PServiceProto.PingResponse> ping(
        com.example.p2pnetwork.P2PServiceProto.PingRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getPingMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * RPC para obtener la información de un nodo
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.example.p2pnetwork.P2PServiceProto.NodeInfoResponse> getNodeInfo(
        com.example.p2pnetwork.P2PServiceProto.NodeInfoRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetNodeInfoMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_PING = 0;
  private static final int METHODID_GET_NODE_INFO = 1;

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
        case METHODID_PING:
          serviceImpl.ping((com.example.p2pnetwork.P2PServiceProto.PingRequest) request,
              (io.grpc.stub.StreamObserver<com.example.p2pnetwork.P2PServiceProto.PingResponse>) responseObserver);
          break;
        case METHODID_GET_NODE_INFO:
          serviceImpl.getNodeInfo((com.example.p2pnetwork.P2PServiceProto.NodeInfoRequest) request,
              (io.grpc.stub.StreamObserver<com.example.p2pnetwork.P2PServiceProto.NodeInfoResponse>) responseObserver);
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
              .addMethod(getPingMethod())
              .addMethod(getGetNodeInfoMethod())
              .build();
        }
      }
    }
    return result;
  }
}
