package semaphore.demo7.test.run;


import semaphore.demo7.extthread.MyThread;
import semaphore.demo7.service.Service;

public class Run {

	public static void main(String[] args) {
		Service service = new Service();
		MyThread[] threadArray = new MyThread[10];
		for (int i = 0; i < threadArray.length; i++) {
			threadArray[i] = new MyThread(service);
			threadArray[i].start();
		}
	}

}
