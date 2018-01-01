package executor.demo4.test;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import executor.demo4.myrunnable.MyRunnable1;
import executor.demo4.mythreadfactory.MyThreadFactoryA;

/**
 * 定义自定义线程工厂 ： MyThreadFactoryA
 */
public class Test1 {
	public static void main(String[] args) throws InterruptedException {
		MyRunnable1 myRunnable = new MyRunnable1();
		ThreadPoolExecutor pool = new ThreadPoolExecutor(2, 99999, 9999L,
				TimeUnit.SECONDS, new LinkedBlockingQueue<Runnable>(),
				new MyThreadFactoryA());
		pool.execute(myRunnable);
	}
}
