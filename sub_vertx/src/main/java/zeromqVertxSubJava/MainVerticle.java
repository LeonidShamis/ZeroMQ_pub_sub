package zeromqVertxSubJava;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.DeploymentOptions;

public class MainVerticle extends AbstractVerticle {

  @Override
  public void start(Future<Void> startFuture) {

    System.out.println("[Main] Running in " + Thread.currentThread().getName());

    vertx.deployVerticle("zeromqVertxSubJava.JeroMQSubscriberVerticle", new DeploymentOptions().setWorker(true));
  }
}
