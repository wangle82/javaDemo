package semaphore.demo5.test.run;


import semaphore.demo5.extthread.MyThread;
import semaphore.demo5.myservice.MyService;

public class Run {

	public static void main(String[] args) {
		MyService service = new MyService();

		MyThread firstThread = new MyThread(service);
		firstThread.start();

		MyThread secondThread = new MyThread(service);
		secondThread.start();

		MyThread thridThread = new MyThread(service);
		thridThread.start();

//		MyThread[] threadArray = new MyThread[4];
//		for (int i = 0; i < 4; i++) {
//			threadArray[i] = new MyThread(service);
//			threadArray[i].start();
//		}

	}

}
