package semaphore.demo4.extthread;


import semaphore.demo4.myservice.MyService;

public class MyThread extends Thread {

	private MyService myService;

	public MyThread(MyService myService) {
		super();
		this.myService = myService;
	}

	@Override
	public void run() {
		myService.testMethod();
	}

}
