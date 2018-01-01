package cyclicbrarrier.demo5.extthread;


import cyclicbrarrier.demo5.service.MyService;

public class ThreadA extends Thread {

	private MyService service;

	public ThreadA(MyService service) {
		super();
		this.service = service;
	}

	@Override
	public void run() {
		service.beginRun();
	}

}
