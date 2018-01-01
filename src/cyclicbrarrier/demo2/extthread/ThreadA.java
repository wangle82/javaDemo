package cyclicbrarrier.demo2.extthread;

import java.util.Date;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class ThreadA extends Thread {

    private CyclicBarrier cbRef;

    public ThreadA(CyclicBarrier cbRef) {
        super();
        this.cbRef = cbRef;
    }

    @Override
    public void run() {
        try {
            System.out.println(Thread.currentThread().getName() + " begin =" + new Date(System.currentTimeMillis()) + " 等待凑齐2个继续运行");
            cbRef.await();//当进入的线程数量,等于循环栅栏的数量时候，会重置
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
    }
}
