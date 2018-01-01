package cyclicbrarrier.demo1.test.run;

import cyclicbrarrier.demo1.extthread.MyThread;

import java.util.concurrent.CyclicBarrier;


public class Run {

	public static void main(String[] args) throws InterruptedException {
		CyclicBarrier cbRef = new CyclicBarrier(5, new Runnable() {
			public void run() {
				//全部完成后的处理
				System.out.println("所有线程全都到了！");
			}
		});
		//创建线程
		MyThread[] threadArray = new MyThread[5];
		for (int i = 0; i < threadArray.length; i++) {
			threadArray[i] = new MyThread(cbRef);
		}

		for (int i = 0; i < threadArray.length; i++) {
			threadArray[i].start();
			Thread.sleep(2000);
		}
	}
}
