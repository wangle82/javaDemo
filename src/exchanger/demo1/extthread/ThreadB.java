package exchanger.demo1.extthread;

import java.util.concurrent.Exchanger;

public class ThreadB extends Thread {

	private Exchanger<String> exchanger;

	public ThreadB(Exchanger<String> exchanger) {
		super();
		this.exchanger = exchanger;
	}

	@Override
	public void run() {
		try {
			String value = exchanger.exchange("B");
			System.out.println("在线程B中得到线程A的值=" + value);
			System.out.println("B end!");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
