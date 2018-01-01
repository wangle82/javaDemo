package semaphore.demo8.tools;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 信号量:
 * 作一个连接池
 */
public class ConnectionPool {

	private int poolMaxSize = 5;
	private int semaphorePermits = 5;
	private List<String> list = new ArrayList<String>();
	private Semaphore concurrencySemaphore = new Semaphore(semaphorePermits);
	private ReentrantLock lock = new ReentrantLock();
	private Condition condition = lock.newCondition();

	public ConnectionPool() {
		for (int i = 0; i < poolMaxSize; i++) {
			list.add("连接池 pool 连接 : " + (i + 1));
		}
	}
	//获取连接池的时候，信号量减少
	public String get() {
		String getConnect = null;
		try {
			//获得信号量
			concurrencySemaphore.acquire();
			lock.lock();
			//阻塞
			while (list.size() == 0) {
				condition.await();
			}
			//获得一个连接，并从连接池里减少一个
			getConnect = list.remove(0);
			lock.unlock();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return getConnect;
	}

	//使用完连接池的时候，放回连接，信号量增加
	public void put(String stringValue) {
		lock.lock();
		list.add(stringValue); //把连接再返回在线程池中
		//唤醒 : 唤醒那些没有获得连接池的线程
		condition.signalAll();
		lock.unlock();
		//获得信号量
		concurrencySemaphore.release();
	}

}
