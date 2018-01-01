package semaphore.demo1.service;

import java.util.Date;
import java.util.concurrent.Semaphore;

/**
 * 信号量的获取和释放： 来控制进入线程的数量
 */
public class Service {
    //初始的信号量的值2 : 只允许两个线程拿到许可，如果其他线程想要进来的话，必须等已经进来的线程执行完成
    private Semaphore semaphore = new Semaphore(2);

    public void testMethod() {
        try {
            //每次获得无参一个许可，许可的总数减1，也可以设置参数获得n个许可
            semaphore.acquire();
            System.out.println(Thread.currentThread().getName() + "begin timer=" + new Date(System.currentTimeMillis()));
            Thread.sleep(2000);
            System.out.println(Thread.currentThread().getName() + "end timer=" + new Date(System.currentTimeMillis()));
            //每次释放一个许可
            semaphore.release();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
