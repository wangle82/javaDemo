package countDownLatch.demo1.extthread;

import java.util.concurrent.CountDownLatch;

public class MyThread extends Thread {

    private CountDownLatch maxRuner;

    public MyThread(CountDownLatch maxRuner) {
        super();
        this.maxRuner = maxRuner;
    }

    @Override
    public void run() {
        try {
            System.out.println("Thread" + Thread.currentThread().getName() + " : 开始工作");
            Thread.sleep(5000);
            maxRuner.countDown();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
