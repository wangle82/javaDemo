package forkjoin.test.run;

import forkjoin.mytask.MyRecursiveTask;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;


public class Run {

	public static void main(String[] args) throws InterruptedException {
		try {
			MyRecursiveTask task = new MyRecursiveTask(1, 10);
			ForkJoinPool pool = new ForkJoinPool();
			pool.submit(task);
			System.out.println("结果值为：" + task.get());
//			System.out.println("结果值为：" + task.join()); //不能主线程捕获异常
		} catch (ExecutionException e) {
			e.printStackTrace();
		}
	}
}
