package zeromqVertxSubJava;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.DeploymentOptions;
import io.vertx.core.Future;

public class MainVerticle extends AbstractVerticle {

  @Override
  public void start(Future<Void> startFuture) {

    System.out.println("[Main] Running in " + Thread.currentThread().getName());

    vertx.deployVerticle("zeromqVertxSubJava.JeroMQSubscriberVerticle", new DeploymentOptions().setWorker(true));
  }
}
