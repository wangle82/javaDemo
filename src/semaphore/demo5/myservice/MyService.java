package semaphore.demo5.myservice;

import java.util.concurrent.Semaphore;

public class MyService {

	private boolean isFair = false;
	private Semaphore semaphore = new Semaphore(1, true);

	public void testMethod() {
		try {
			semaphore.acquire();
			System.out
					.println("ThreadName=" + Thread.currentThread().getName());
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			semaphore.release();
		}
	}

}
