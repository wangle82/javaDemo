package collection.demo7;

public class ThreadA extends Thread {

	private MyService myService;

	public ThreadA(MyService myService) {
		super();
		this.myService = myService;
	}

	@Override
	public void run() {
		try {
			while (!myService.queue.isEmpty()) {
				User take = myService.queue.take();
				System.out.println(take.name + " : " + take.score );
				Thread.sleep(1000);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
