package collection.demo3.extthread;


import collection.demo3.myservice.MyService;

public class ThreadB extends Thread {

	private MyService service;

	public ThreadB(MyService service) {
		super();
		this.service = service;
	}

	@Override
	public void run() {
		while (!service.queue.isEmpty()) {
			System.out.println(Thread.currentThread().getName() + "从尾移除元素 :" + service.queue.pollLast()+"列表size " + service.queue.size());
		}
	}

}
