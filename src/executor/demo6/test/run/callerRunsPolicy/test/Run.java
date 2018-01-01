package executor.demo6.test.run.callerRunsPolicy.test;

import java.util.Date;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import executor.demo6.test.run.callerRunsPolicy.extthread.MyThreadA;

/**
 * 当任务添加到线程池中被拒绝时，会使用调用的线程池的main主线程对象处理被拒绝的任务
 */
public class Run {

	public static void main(String[] args) {
		MyThreadA a = new MyThreadA();
		ThreadPoolExecutor pool = new ThreadPoolExecutor(2, 3, 10, TimeUnit.SECONDS, new ArrayBlockingQueue(2), new ThreadPoolExecutor.CallerRunsPolicy());
		System.out.println("a begin " + Thread.currentThread().getName() + " " + new Date(System.currentTimeMillis()));
		pool.execute(a);
		pool.execute(a);
		pool.execute(a);
		pool.execute(a);
		pool.execute(a);
		pool.execute(a);
		System.out.println("a   end " + Thread.currentThread().getName() + " " + new Date(System.currentTimeMillis()));
	}
}
