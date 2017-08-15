package zeromqVertxSubJava;

import io.vertx.core.AbstractVerticle;

import org.zeromq.ZMQ;

public class JeroMQSubscriberVerticle extends AbstractVerticle {

  @Override
  public void start() {

    System.out.println("[Worker] Starting in " + Thread.currentThread().getName());

    ZMQ.Context context = ZMQ.context(1);

    ZMQ.Socket subscriber = context.socket(ZMQ.SUB);
    subscriber.connect("tcp://127.0.0.1:8001");
    subscriber.connect("tcp://127.0.0.1:8002");

    System.out.println("subscriber connected to ports 8001 & 8002");
    System.out.println("receiving messages...");

    // no filtering
    subscriber.subscribe(ZMQ.SUBSCRIPTION_ALL); // no filtering

    String message;

    // server continuously sends messages until interrupted
    while (!Thread.currentThread().isInterrupted()) {

        message = subscriber.recvStr(0).trim();
        String[] result = message.split(" ");
        System.out.println("exchange: " + result[0] + ", update: " + result[1]);
    }
    subscriber.close();
    context.term();
  }
}
