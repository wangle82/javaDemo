package cyclicbrarrier.demo5.service;

import java.util.Date;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class MyService {
	private CyclicBarrier cbRef;

	public MyService(CyclicBarrier cbRef) {
		super();
		this.cbRef = cbRef;
	}

	public void beginRun() {
		try {
			Thread.sleep(1000);
			System.out.println(Thread.currentThread().getName() +" : 到起跑点了" );
			cbRef.await(); //第一次通过屏障

			System.out.println(Thread.currentThread().getName() + ": 准备起跑" );
			cbRef.await();//第二次通过屏障,表示CyclicBarrier是可以重用,CountDownLatch是做不到，所以只能申请多个CountDownLatch
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (BrokenBarrierException e) {
			e.printStackTrace();
		}
	}
}
