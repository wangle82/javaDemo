package countDownLatch.demo1.test.run;

import countDownLatch.demo1.extthread.MyThread;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;


public class Run {
	public static void main(String[] args) throws InterruptedException {
		CountDownLatch maxRuner = new CountDownLatch(5);
		System.out.println("maxRuner数量 = " + maxRuner.getCount());
		MyThread[] tArray = new MyThread[Integer.parseInt("" + maxRuner.getCount())];
		for (int i = 0; i < tArray.length; i++) {
			tArray[i] = new MyThread(maxRuner);
			tArray[i].setName("线程" + (i + 1));
			tArray[i].start();
		}
		maxRuner.await(); //必须count计数不为0
		//如果在指定的时间内，子线程执行不完，就在下面的逻辑
//		maxRuner.await(1,TimeUnit.SECONDS);
		System.out.println("线程都完成！");
	}
}
