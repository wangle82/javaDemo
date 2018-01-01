package cyclicbrarrier.demo5.test;

import cyclicbrarrier.demo5.extthread.ThreadA;
import cyclicbrarrier.demo5.service.MyService;

import java.util.concurrent.CyclicBarrier;



public class Test {

	public static void main(String[] args) throws InterruptedException {
		CyclicBarrier cbRef = new CyclicBarrier(4, new Runnable() {
			@Override
			public void run() {
				//这里就相当于裁判员: 发号时令
				System.out.println("下一步");
			}
		});
		MyService service = new MyService(cbRef);
		ThreadA threadA1 = new ThreadA(service);
		threadA1.setName("ThreadA");
		threadA1.start();
		ThreadA threadA2 = new ThreadA(service);
		threadA2.setName("ThreadB");
		threadA2.start();
		ThreadA threadA3 = new ThreadA(service);
		threadA3.setName("ThreadC");
		threadA3.start();
		ThreadA threadA4 = new ThreadA(service);
		threadA4.setName("ThreadD");
		threadA4.start();
	}
}
