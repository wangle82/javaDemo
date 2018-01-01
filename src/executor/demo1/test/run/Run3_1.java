package executor.demo1.test.run;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Run3_1 {
	// 队列使用LinkedBlockingQueue类
	// 并且线程数量>corePoolSize时将其余的任务放入队列中
	// 同一时间最多只能有7个线程在运行
	// 所以keepAliveTime>5 时 corePoolSize
	// 如果使用LinkedBlockingQueue类，则maximumpoolsize忽略
	public static void main(String[] args) throws InterruptedException {
		Runnable runnable = new Runnable() {
			@Override
			public void run() {
				try {
					System.out.println(Thread.currentThread().getName() + " run!" + System.currentTimeMillis());
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		};
		ThreadPoolExecutor executor = new ThreadPoolExecutor(7, 8, 5, TimeUnit.SECONDS, new LinkedBlockingQueue<Runnable>());
		executor.execute(runnable);// 1
		executor.execute(runnable);// 2
		executor.execute(runnable);// 3
		executor.execute(runnable);// 4
		executor.execute(runnable);// 5
		executor.execute(runnable);// 6
		executor.execute(runnable);// 7
		executor.execute(runnable);// 8
//		executor.execute(runnable);// 7
//		executor.execute(runnable);// 8
		Thread.sleep(300);
		System.out.println("A:" + executor.getCorePoolSize());
		System.out.println("A:" + executor.getPoolSize());
		System.out.println("A:" + executor.getQueue().size());
		Thread.sleep(6000);
		System.out.println("=============查看线程池中的线程数量=============");
		System.out.println("B:" + executor.getCorePoolSize());
		System.out.println("B:" + executor.getPoolSize());
		System.out.println("B:" + executor.getQueue().size());
	}

}
