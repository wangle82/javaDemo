package collection.demo6;

import java.util.concurrent.ArrayBlockingQueue;

/**
 * Created by wangle on 2017/12/24.
 */
public class Consumer implements Runnable{

    //容器
    private final ArrayBlockingQueue<String> queue;

    public Consumer(ArrayBlockingQueue<String> queue){
        this.queue = queue;
    }

    /* (non-Javadoc)
     * @see java.lang.Runnable#run()
     */
    @Override
    public void run() {
        while(true){
            consume();
        }
    }

    public void consume(){
        /**
         * take()方法和put()方法是对应的，从中拿一个数据，如果拿不到线程挂起
         * poll()方法和offer()方法是对应的，从中拿一个数据，如果没有直接返回null
         */
        try {
            String bread = queue.take();
            System.out.println("consumer:"+bread+String.valueOf(System.currentTimeMillis()));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
