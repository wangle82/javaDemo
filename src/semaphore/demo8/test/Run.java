package semaphore.demo8.test;


import semaphore.demo8.extthread.MyThread;
import semaphore.demo8.tools.ConnectionPool;

public class Run {

	public static void main(String[] args) {

		ConnectionPool pool = new ConnectionPool();
		MyThread[] threadArray = new MyThread[5];

		for (int i = 0; i < threadArray.length; i++) {
			threadArray[i] = new MyThread(pool);
		}

		for (int i = 0; i < threadArray.length; i++) {
			threadArray[i].start();
		}

	}
}
