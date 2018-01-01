package executor.demo5.test;

import executor.demo5.myrunnable.MyRunnable1;

import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;


public class Test1 {
    public static void main(String[] args) throws InterruptedException {
        MyRunnable1 myRunnable1 = new MyRunnable1("线程1");
        MyRunnable1 myRunnable2 = new MyRunnable1("线程2");
        MyRunnable1 myRunnable3 = new MyRunnable1("线程3");
        MyRunnable1 myRunnable4 = new MyRunnable1("线程4");
        ThreadPoolExecutor pool = new ThreadPoolExecutor(2, 3, 9999L,
                TimeUnit.SECONDS, new SynchronousQueue<Runnable>());
        pool.execute(myRunnable1);
        pool.execute(myRunnable2);
        pool.execute(myRunnable3);
        pool.execute(myRunnable4);
    }
}
