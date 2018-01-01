package cyclicbrarrier.demo2.test;

import cyclicbrarrier.demo2.extthread.ThreadA;

import java.util.concurrent.CyclicBarrier;

public class Test {
	/**
	 * 可以循环分批次来做处理
	 * @param args
	 * @throws InterruptedException
	 */
	public static void main(String[] args) throws InterruptedException {
		CyclicBarrier cbRef = new CyclicBarrier(2, new Runnable() {
			@Override
			public void run() {
				//可以分批来实现同步处理
				System.out.println("全来了！");
			}
		});
		//验证循环栅栏 : 栅栏的阈值的时候，会重新设置
		for (int i = 0; i < 10; i++) {
			ThreadA threadA1 = new ThreadA(cbRef);
			threadA1.start();
			//为了测试效果：每隔1秒启动一个线程
			Thread.sleep(1000);
			System.out.println(cbRef.getNumberWaiting());

		}
	}
}
