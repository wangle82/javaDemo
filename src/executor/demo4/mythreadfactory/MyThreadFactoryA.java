package executor.demo4.mythreadfactory;

import java.util.Date;
import java.util.concurrent.ThreadFactory;

public class MyThreadFactoryA implements ThreadFactory {
	@Override
	public Thread newThread(Runnable r) {
		Thread newThread = new Thread(r);
		newThread.setName("线程名称FactoryA_" + new Date());
		return newThread;
	}
}
