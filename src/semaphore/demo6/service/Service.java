package semaphore.demo6.service;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class Service {

	private Semaphore semaphore = new Semaphore(1);

	/**
	 * 可以设置一下： 线程的等待获得信号量的时间
	 */
	public void testMethod() {
		try {
			if (semaphore.tryAcquire(1, 3, TimeUnit.SECONDS)) {
				System.out.println("ThreadName=" + Thread.currentThread().getName() + "获取到信号了,进入");
				Thread.sleep(4000);
				semaphore.release(1);
			} else {
				System.out.println("ThreadName=" + Thread.currentThread().getName() + "尝试获取不到信号了，未进入");
			}

		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
