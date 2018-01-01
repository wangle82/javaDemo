package cyclicbrarrier.demo4.extthread;


import cyclicbrarrier.demo4.service.MyService;

public class MyThread extends Thread {

	private MyService myService;

	public MyThread(MyService myService) {
		super();
		this.myService = myService;
	}

	@Override
	public void run() {
		myService.testA();
	}

}
