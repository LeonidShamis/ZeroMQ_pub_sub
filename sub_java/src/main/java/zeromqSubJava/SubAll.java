package zeromqSubJava;

import org.zeromq.ZMQ;

public class SubAll {

    public static void main(String[] args) {
        
        ZMQ.Context context = ZMQ.context(1);

        ZMQ.Socket subscriber = context.socket(ZMQ.SUB);
        subscriber.connect("tcp://127.0.0.1:8001");
        subscriber.connect("tcp://127.0.0.1:8002");

        System.out.println("subscriber connected to ports 8001 & 8002");
        System.out.println("receiving messages...");

        // no filtering
        subscriber.subscribe(ZMQ.SUBSCRIPTION_ALL); // no filtering

        int numOfMessages = 1000;
        String message;

        for (int i = 0; i < numOfMessages; i++) {
            message = subscriber.recvStr(0).trim();
            String[] result = message.split(" ");
            System.out.println("exchange: " + result[0] + ", update: " + result[1]);
        }

        subscriber.close();
        context.term();
    }
}
