package collection.demo3.test1;


import collection.demo3.extthread.ThreadA;
import collection.demo3.extthread.ThreadB;
import collection.demo3.myservice.MyService;

public class Test {

	public static void main(String[] args) {
		try {
			MyService service = new MyService();
			ThreadA a = new ThreadA(service);
			ThreadB b = new ThreadB(service);

			a.start();
			b.start();
			a.join();
			b.join();
			// a和b线程都执行完成
			System.out.println("queue" + service.queue.size());
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
