package futureAndcallable.demo4.test;

import futureAndcallable.demo4.mycallable.MyCallable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Future的缺点:  必须所有的结果，必须在最后一下拿
 */
public class Test {
	public static void main(String[] args) {
		try {
			MyCallable callable1 = new MyCallable("任务1", 1000);
			MyCallable callable2 = new MyCallable("任务2", 1000);
			MyCallable callable3 = new MyCallable("任务3", 1000);
			MyCallable callable4 = new MyCallable("任务4", 1000);
			MyCallable callable5 = new MyCallable("任务5", 1000);

			List<Callable> callableList = new ArrayList<Callable>();
			callableList.add(callable1);
			callableList.add(callable2);
			callableList.add(callable3);
			callableList.add(callable4);
			callableList.add(callable5);

			List<Future> futureList = new ArrayList<Future>();
			ThreadPoolExecutor executor = new ThreadPoolExecutor(5, 10, 5, TimeUnit.SECONDS, new LinkedBlockingDeque<Runnable>());
			for (int i = 0; i < 5; i++) {
				futureList.add(executor.submit(callableList.get(i)));
			}
			for (int i = 0; i < 5; i++) {
				System.out.println(futureList.get(i).get() + " " + new Date(System.currentTimeMillis()));
			}

			executor.shutdown();

		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}

	}
}
