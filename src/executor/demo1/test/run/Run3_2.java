package executor.demo1.test.run;

import java.util.Date;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Run3_2 {
	// 队列使用SynchronousQueue类
	// 并且线程数量>corePoolSize时
	// 将其余的任务也放入池中，总数量为8，
	// 并没有超过maximumPoolSize值
	// 由于运行的线程数为8，数量上>corePoolSize为7的值 所以keepAliveTime>5时清除大于corePoolSize线程
	// 如果使用SynchronousQueue是受影响的,maximumpoolsize
	public static void main(String[] args) throws InterruptedException {
		Runnable runnable = new Runnable() {
			@Override
			public void run() {
				try {
					System.out.println(Thread.currentThread().getName()
							+ " run!" + new Date(System.currentTimeMillis()));
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		};
		ThreadPoolExecutor executor = new ThreadPoolExecutor(7, 8, 5,
				TimeUnit.SECONDS, new SynchronousQueue<Runnable>());
		executor.execute(runnable);// 1
		executor.execute(runnable);// 2
		executor.execute(runnable);// 3
		executor.execute(runnable);// 4
		executor.execute(runnable);// 5
		executor.execute(runnable);// 6
		executor.execute(runnable);// 7
		executor.execute(runnable);// 8
//		executor.execute(runnable);// 9
//		executor.execute(runnable);// 10

		Thread.sleep(2000);
		System.out.println("A:" + executor.getCorePoolSize());
		System.out.println("A:" + executor.getPoolSize());
		System.out.println("A:" + executor.getQueue().size());

		Thread.sleep(10000);
		System.out.println("=============查看线程池中的线程数量=============");
		System.out.println("B:" + executor.getCorePoolSize());
		System.out.println("B:" + executor.getPoolSize());
		System.out.println("B:" + executor.getQueue().size());
		executor.shutdown();
	}
}
