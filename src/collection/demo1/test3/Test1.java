package collection.demo1.test3;

public class Test1 {
	/**
	 * 保证两个线程也可以按顺序取出ConcurrentSkipListMap里面的数值
	 * @param args
	 */
	public static void main(String[] args) {
		MyService1 service = new MyService1();
		ThreadA a = new ThreadA(service);
		ThreadA b = new ThreadA(service);

		a.start();
		b.start();
	}
}
