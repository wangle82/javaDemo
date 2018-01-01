package semaphore.demo3.service;

import java.util.Date;
import java.util.concurrent.Semaphore;

public class Service {

	private Semaphore semaphore = new Semaphore(1);

	public void testMethod() {
//		//中断方法：
//		try {
//			semaphore.acquire();
//			System.out.println(Thread.currentThread().getName() + " begin timer=" + new Date(System.currentTimeMillis()));
//			Thread.sleep(2000);
//			System.out.println(Thread.currentThread().getName() + "   end timer=" + new Date(System.currentTimeMillis()));
//			semaphore.release();
//		} catch (InterruptedException e) {
//			System.out.println("线程" + Thread.currentThread().getName() + "进入了catch");
//			e.printStackTrace();
//		}

		//非中断方法 : 不会被中断，继续执行
		semaphore.acquireUninterruptibly();
		System.out.println(Thread.currentThread().getName() + " begin timer=" + new Date(System.currentTimeMillis()));
		for (int i = 0; i < Integer.MAX_VALUE/50 ; i++) {
			Math.random();
		}
		System.out.println(Thread.currentThread().getName() + "   end timer=" + new Date(System.currentTimeMillis()));
		semaphore.release();
	}
}
