package semaphore.demo2.test;

import java.util.concurrent.Semaphore;

public class Run {
	/**
	 *  可以通过调用release实现动态增加信号的情况, 可以查看当前信号量的数量，可以查看将当前所有信号量的个数设置为0
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			Semaphore semaphore = new Semaphore(5);
			System.out.println("初始许可个数 : " + semaphore.availablePermits());//得到当前许可个数

			//许可减法操作
			semaphore.acquire();
			System.out.println("许可个数 : " + semaphore.availablePermits());//得到当前许可个数

			semaphore.acquire();
			System.out.println("许可个数 : " + semaphore.availablePermits());//得到当前许可个数

			semaphore.acquire();
			System.out.println("许可个数 : " + semaphore.availablePermits());//得到当前许可个数

			semaphore.acquire();
			System.out.println("许可个数 : " + semaphore.availablePermits());//得到当前许可个数

			semaphore.acquire();
			System.out.println("许可个数 : " + semaphore.availablePermits());//得到当前许可个数
			//许可加法操作
			semaphore.release();
			System.out.println("许可个数 : " + semaphore.availablePermits());
			semaphore.release();
			System.out.println("许可个数 : " + semaphore.availablePermits());
			semaphore.release();
			System.out.println("许可个数 : " + semaphore.availablePermits());
			semaphore.release();
			System.out.println("许可个数 : " + semaphore.availablePermits());
			semaphore.release();
			System.out.println("许可个数 : " + semaphore.availablePermits());
			semaphore.release();
			System.out.println("许可个数 : " + semaphore.availablePermits());
			//release 许可加法操作
			semaphore.release(4);
			System.out.println("许可个数 : " + semaphore.availablePermits());
			//将信号量设置为0
			semaphore.drainPermits();
			System.out.println("许可个数 : " + semaphore.availablePermits());
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

}
