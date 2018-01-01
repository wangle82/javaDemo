package cyclicbrarrier.demo1.extthread;

import java.util.Date;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class MyThread extends Thread {

	private CyclicBarrier cbRef;

	public MyThread(CyclicBarrier cbRef) {
		super();
		this.cbRef = cbRef;
	}

	@Override
	public void run() {
		try {
//			Thread.sleep(1000);
			System.out.println(Thread.currentThread().getName() + " 到了! " + new Date(System.currentTimeMillis()));
			cbRef.await();//只需要await就可以, 每到了一个线程，屏障数加1
//			cbRef.await(1, TimeUnit.SECONDS);//如果在指定时间内，没有达到栅栏的阈值，有没超时异常
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (BrokenBarrierException e) {
			e.printStackTrace();
		}
//		catch (TimeoutException e) {
//			e.printStackTrace();
//		}

	}
}
