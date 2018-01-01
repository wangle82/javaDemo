package collection.demo2.test1;


import collection.demo2.myservice.MyService1;

public class ThreadA extends Thread {

	private MyService1 service;

	public ThreadA(MyService1 service) {
		super();
		this.service = service;
	}

	@Override
	public void run() {
		for (int i = 0; i < 50; i++) {
			service.queue.add("threadA" + (i + 1));
			System.out.println("threadA" +"加入元素 ："+ (i + 1));
		}
	}

}
