package semaphore.demo7.service;

import java.util.Date;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 是允许多个线程同时处理任务，但执行任务的顺序同步，为了避免影响
 */
public class Service {
    //每次允许3个线程同时进入
    private Semaphore semaphore = new Semaphore(3);
    //保证每个线程的之间是同步的
    private ReentrantLock lock = new ReentrantLock();

    public void sayHello() {
        try {
            semaphore.acquire();
            //非同步的部分
            System.out.println("ThreadName=" + Thread.currentThread().getName() + "准备工作开始");
            lock.lock();
            //同步的部分
            System.out.println("工作开始" + new Date(System.currentTimeMillis()));

            for (int i = 0; i < 5; i++) {
                System.out.println(Thread.currentThread().getName() + "打印" + (i + 1));
            }
            //同步的部分
            System.out.println("工作完成" + new Date(System.currentTimeMillis()));

            semaphore.release();
            //非同步的部分
            System.out.println("ThreadName=" + Thread.currentThread().getName() + "工作完程结束");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
}
