package cyclicbrarrier.demo4.service;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class MyService {

	private CyclicBarrier cbRef;

	public MyService(CyclicBarrier cbRef) {
		super();
		this.cbRef = cbRef;
	}

	/**
	 * 相互等待: 多个线程之间相互等待
	 * @param count
	 */
	private void beginRun(int count) {
		try {
			System.out.println(Thread.currentThread().getName() + " 到了 在等待其它人都到了开始起跑");
			if (Thread.currentThread().getName().equals("Thread-2")) {
				System.out.println("thread-2进来了");
				Thread.sleep(5000);
				//CyclicBarrier对于线程的中断interrupt处理，如果有一个线程由于中断或者超时提前离开了屏障点，其他
				//线程也会离开中断点
//				Thread.currentThread().interrupt();
				//如果是运行时异常，其他线程是不会离开屏障点，可以继续等待
//				Integer.parseInt("d");
			}
			cbRef.await();
			System.out.println("都到了，开始跑!");
			System.out.println(Thread.currentThread().getName() + " 到达终点，并结束第" + count + "赛段");

		} catch (InterruptedException e) {
			System.out.println("进入了InterruptedException e " + cbRef.isBroken());
			e.printStackTrace();
		} catch (BrokenBarrierException e) {
			System.out.println("进入了BrokenBarrierException e " + cbRef.isBroken());
			e.printStackTrace();
		}

	}

	public void testA() {
		for (int i = 0; i < 1; i++) {
			beginRun(i + 1);
		}
	}
}
