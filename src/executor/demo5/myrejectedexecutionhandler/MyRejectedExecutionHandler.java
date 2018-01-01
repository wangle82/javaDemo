package executor.demo5.myrejectedexecutionhandler;

import executor.demo5.myrunnable.MyRunnable1;

import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * 自定义拒绝策略
 */
public class MyRejectedExecutionHandler implements RejectedExecutionHandler {
	public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
		//在拒绝的时候，会做一定的处理
		System.out.println(((MyRunnable1) r).getUsername() + " 被拒绝执行");
	}
}
