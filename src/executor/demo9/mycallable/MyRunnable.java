package executor.demo9.mycallable;

import java.util.Date;

public class MyRunnable implements Runnable {

	@Override
	public void run() {
		try {
			System.out.println("begin =" + new Date(System.currentTimeMillis()) + " ThreadName=" + Thread.currentThread().getName());
			Thread.sleep(1000);
			System.out.println("end =" + new Date(System.currentTimeMillis()) + " ThreadName=" + Thread.currentThread().getName());
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
