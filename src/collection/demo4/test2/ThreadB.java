package collection.demo4.test2;

public class ThreadB extends Thread {

	private MyServiceB service;

	public ThreadB(MyServiceB service) {
		super();
		this.service = service;
	}

	@Override
	public void run() {
		for (int i = 0; i < 100; i++) {
			service.list.add("anyString");
		}
	}
}