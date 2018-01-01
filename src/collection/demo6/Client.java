package collection.demo6;

import java.util.concurrent.ArrayBlockingQueue;

/**
 * Created by wangle on 2017/12/24.
 */
public class Client {
    public static void main(String[] args) {
        /**
         * 有界的阻塞队列
         */
        ArrayBlockingQueue<String> queue = new ArrayBlockingQueue<String>(10);
        new Thread(new Producer(queue)).start();
        new Thread(new Producer(queue)).start();
        new Thread(new Consumer(queue)).start();
        new Thread(new Consumer(queue)).start();
        new Thread(new Consumer(queue)).start();
    }
}
