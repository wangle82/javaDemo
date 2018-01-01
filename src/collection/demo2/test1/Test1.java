package collection.demo2.test1;


import collection.demo2.myservice.MyService1;

public class Test1 {

	public static void main(String[] args) {
		try {
			MyService1 service = new MyService1();
			ThreadA a = new ThreadA(service);
			ThreadB b = new ThreadB(service);

			a.start();
			b.start();
			//主线程，等两个线程都完成
			a.join();
			b.join();

			System.out.println(service.queue.size());

		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
