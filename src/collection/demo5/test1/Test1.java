package collection.demo5.test1;

public class Test1 {

	public static void main(String[] args) throws InterruptedException {
		MyServiceA service = new MyServiceA();

		ThreadA[] aArray = new ThreadA[100];
		for (int i = 0; i < aArray.length; i++) {
			aArray[i] = new ThreadA(service);
		}
		for (int i = 0; i < aArray.length; i++) {
			aArray[i].start();
		}
		Thread.sleep(3000);
		System.out.println(service.set.size());// 正确的结果10000，但是Set保证不了
	}

}
