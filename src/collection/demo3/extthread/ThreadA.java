package collection.demo3.extthread;


import collection.demo3.myservice.MyService;

public class ThreadA extends Thread {

	private MyService service;

	public ThreadA(MyService service) {
		super();
		this.service = service;
	}

	@Override
	public void run() {
		while (!service.queue.isEmpty()) {
//			service.queue.pollFirst();
			System.out.println(Thread.currentThread().getName() + "从头移除元素 :" + service.queue.pollFirst() + "列表size " + service.queue.size());

		}
	}

}
