import com.google.inject.Guice;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import java.io.IOException;
import java.util.logging.Logger;
import javax.inject.Inject;

/**
 * Created by jeff on 2017-03-07.
 */
public class GreeterServer {
  @Inject HelloWorldService helloWorldService;


  private int port = 50051;
  private Server server;
  private Logger logger = Logger.getLogger(GreeterServer.class.toString());

  private void start() throws IOException {
    logger.info("Starting server");
    server = ServerBuilder.forPort(port)
        .addService(helloWorldService)
        .build()
        .start();
  }

  private void blockUntilShutdown() throws InterruptedException {
    while (server != null) {
      server.awaitTermination();
    }
  }

  public static void main(String[] args) {
    GreeterServer server = Guice.createInjector(new Module()).getInstance(GreeterServer.class);
    try {
      server.start();
      server.blockUntilShutdown();
    } catch (IOException e) {
      e.printStackTrace();
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }
}
