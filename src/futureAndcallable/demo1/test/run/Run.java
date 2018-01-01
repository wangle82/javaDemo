package futureAndcallable.demo1.test.run;

import futureAndcallable.demo1.mycallable.MyCallable;

import java.util.Date;
import java.util.concurrent.*;


public class Run {

	public static void main(String[] args) throws InterruptedException {
		try {
			MyCallable callable = new MyCallable("Test");

			ThreadPoolExecutor executor = new ThreadPoolExecutor(2, 3, 5L, TimeUnit.SECONDS, new LinkedBlockingDeque());
			Future<String> future = executor.submit(callable);
			System.out.println("main: " + new Date(System.currentTimeMillis()));
			//是阻塞方法 : 可以设置超时时间
//			System.out.println("value :" + future.get(2,TimeUnit.SECONDS) + " 是否完成 ：" +future.isDone());
			System.out.println("value :" + future.get() + " 是否完成 ：" +future.isDone());
			System.out.println("main: " + new Date(System.currentTimeMillis()));
			executor.shutdown();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}
//		catch (TimeoutException e){
//			e.printStackTrace();
//		}
	}
}
