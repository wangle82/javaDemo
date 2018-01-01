package collection.demo2.test1;


import collection.demo2.myservice.MyService1;

public class ThreadB extends Thread {

	private MyService1 service;

	public ThreadB(MyService1 service) {
		super();
		this.service = service;
	}

	@Override
	public void run() {
		for (int i = 0; i < 50; i++) {
			service.queue.add("threadB" + (i + 1));
			System.out.println("threadB" +"加入元素 ："+ (i + 1));
		}
	}

}
