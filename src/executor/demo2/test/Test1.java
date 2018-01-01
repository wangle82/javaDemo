package executor.demo2.test;

import executor.demo2.myrunnable.MyRunnable1;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 是使当前未执行完的线程继续执行，不在添加新的任务Task,还有shutdown方法不会阻塞，调用完shutdown方法后，主线程main马上结束
 */
public class Test1 {
	public static void main(String[] args) throws InterruptedException {
		MyRunnable1 myRunnable = new MyRunnable1();
		ThreadPoolExecutor pool = new ThreadPoolExecutor(7, 10, 0L, TimeUnit.SECONDS, new LinkedBlockingQueue<Runnable>());
		pool.execute(myRunnable);
		System.out.println("isShutdown : " + pool.isShutdown());
		Thread.sleep(2000);
		pool.shutdown(); //不会阻塞，主线程
		System.out.println("isShutdown : " + pool.isShutdown());
		System.out.println("main end!");
	}
}
