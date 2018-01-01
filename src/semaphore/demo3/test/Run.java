package semaphore.demo3.test;


import semaphore.demo3.extthread.ThreadA;
import semaphore.demo3.extthread.ThreadB;
import semaphore.demo3.service.Service;

public class Run {

	public static void main(String[] args) throws InterruptedException {
		Service service = new Service();
		ThreadA a = new ThreadA(service);
		a.setName("A");
		a.start();

		ThreadB b = new ThreadB(service);
		b.setName("B");
		b.start();
		b.interrupt();
	}

}
