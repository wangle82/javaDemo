package collection.demo3.myservice;

import java.util.concurrent.ConcurrentLinkedDeque;

public class MyService {
	public ConcurrentLinkedDeque queue = new ConcurrentLinkedDeque();

	public MyService() {
		for (int i = 0; i < 100; i++) {
			queue.add("data_" + (i + 1));
		}
	}

}
