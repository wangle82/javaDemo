package exchanger.demo1.extthread;

import java.util.concurrent.Exchanger;

public class ThreadA extends Thread {

	private Exchanger<String> exchanger;

	public ThreadA(Exchanger<String> exchanger) {
		super();
		this.exchanger = exchanger;
	}

	@Override
	public void run() {
		try {
			String value = exchanger.exchange("A");
			System.out.println("在线程A中得到线程B的值=" + value);
			System.out.println("A end!");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
