package semaphore.demo6.test.run;


import semaphore.demo6.extthread.ThreadA;
import semaphore.demo6.extthread.ThreadB;
import semaphore.demo6.service.Service;

public class Run {

	public static void main(String[] args) {
		Service service = new Service();
		ThreadA a = new ThreadA(service);
		a.setName("A");
		a.start();
		ThreadB b = new ThreadB(service);
		b.setName("B");
		b.start();
	}

}
