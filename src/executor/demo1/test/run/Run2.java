package executor.demo1.test.run;

import java.util.Date;
import java.util.concurrent.*;

public class Run2 {
	// 队列使用LinkedBlockingDeque类 和  队列使用SynchronousQueue类
	// 并且线程数量<=corePoolSize
	// 所以keepAliveTime>5时也不清除核心线程
	public static void main(String[] args) throws InterruptedException {
		Runnable runnable = new Runnable() {
			@Override
			public void run() {
				try {
					System.out.println(Thread.currentThread().getName() + "运行" + new Date(System.currentTimeMillis()));
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		};
		ThreadPoolExecutor executor = new ThreadPoolExecutor(7, 8, 5, TimeUnit.SECONDS, new LinkedBlockingQueue<Runnable>());
//		ThreadPoolExecutor executor = new ThreadPoolExecutor(7, 8, 5, TimeUnit.SECONDS, new SynchronousQueue<Runnable>());

		//线程池启动任务
		executor.execute(runnable);// 1
		executor.execute(runnable);// 2
		executor.execute(runnable);// 3
		executor.execute(runnable);// 4
		executor.execute(runnable);// 5
		executor.execute(runnable);// 6
		executor.execute(runnable);// 7

		Thread.sleep(200);
		System.out.println("A:" + executor.getCorePoolSize());//核心线程数
		System.out.println("A:" + executor.getPoolSize());
		System.out.println("A:" + executor.getQueue().size());

		Thread.sleep(10000);
		System.out.println("=============查看线程池中的线程数量=============");
		System.out.println("B:" + executor.getCorePoolSize());
		System.out.println("B:" + executor.getPoolSize());
		System.out.println("B:" + executor.getQueue().size());

	}
}
