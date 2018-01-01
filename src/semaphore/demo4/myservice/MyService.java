package semaphore.demo4.myservice;

import java.util.concurrent.Semaphore;

public class MyService {

	private Semaphore semaphore = new Semaphore(1);

	/**
	 * 等待的线程：
	 */
	public void testMethod() {
		try {
			semaphore.acquire();
			Thread.sleep(2000);
			System.out.println("还有大约" + semaphore.getQueueLength() + "个线程在等待");
			System.out.println("是否有线程正在等待信号量呢？" + semaphore.hasQueuedThreads());
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			semaphore.release();
		}
	}

}
