package semaphore.demo8.extthread;


import semaphore.demo8.tools.ConnectionPool;

public class MyThread extends Thread {

	private ConnectionPool listPool;

	public MyThread(ConnectionPool listPool) {
		super();
		this.listPool = listPool;
	}

	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			String getString = listPool.get();
			System.out.println(Thread.currentThread().getName() + " 取得值 " + getString);
			listPool.put(getString);
		}
	}

}
