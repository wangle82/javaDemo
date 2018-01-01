package collection.demo7;

import java.util.Random;
import java.util.concurrent.PriorityBlockingQueue;

public class MyService {
	public static PriorityBlockingQueue<User> queue = new PriorityBlockingQueue<User>();

	public MyService() {
		Random random = new Random();
		for (int i = 0; i < 20; i++) {
			queue.add(new User(100*(random.nextInt(10)), "test_"+i));
		}
	}

}
