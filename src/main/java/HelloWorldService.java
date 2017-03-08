import io.grpc.examples.helloworld.GreeterGrpc;
import io.grpc.examples.helloworld.HelloReply;
import io.grpc.examples.helloworld.HelloRequest;
import io.grpc.stub.StreamObserver;

/**
 * Created by jeff on 2017-03-07.
 */
public class HelloWorldService extends GreeterGrpc.GreeterImplBase {
  @Override
  public void sayHello(HelloRequest request, StreamObserver streamObserver) {
    HelloReply reply = HelloReply.newBuilder().setMessage("Hello from the server").build();
    streamObserver.onNext(reply);
    streamObserver.onCompleted();
  }
}