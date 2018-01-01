package exchanger.demo1.test.run;

import exchanger.demo1.extthread.ThreadA;
import exchanger.demo1.extthread.ThreadB;

import java.util.concurrent.Exchanger;


public class Run {
	public static void main(String[] args) {
		Exchanger<String> exchanger = new Exchanger<String>();
		ThreadA a = new ThreadA(exchanger);
		a.start();
		ThreadB b = new ThreadB(exchanger);
		b.start();
	}

}
