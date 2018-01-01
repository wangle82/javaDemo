package semaphore.demo1.test;


import semaphore.demo1.extthread.ThreadA;
import semaphore.demo1.extthread.ThreadB;
import semaphore.demo1.extthread.ThreadC;
import semaphore.demo1.service.Service;

/**
 * Semaphore是如果控制并发梳理:
 * 启动3个线程来执行
 */
public class Run {
	public static void main(String[] args) {
		Service service = new Service();
		ThreadA a = new ThreadA(service);
		a.setName("A");
		ThreadB b = new ThreadB(service);
		b.setName("B");
		ThreadC c = new ThreadC(service);
		c.setName("C");
		a.start();
		b.start();
		c.start();
	}
}
