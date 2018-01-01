package executor.demo9.test.run;

import executor.demo9.mycallable.MyRunnable;

import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;


public class Run {
	public static void main(String[] args) {
		//取得一个单人的计划任务执行池
		ScheduledExecutorService executor = Executors.newSingleThreadScheduledExecutor();
		System.out.println("Time=" + new Date(System.currentTimeMillis()));
//		executor.schedule(new MyRunnable(),5,TimeUnit.SECONDS); //延时5秒执行
		//周期性执行 : 每隔2秒执行一次
		executor.scheduleAtFixedRate(new MyRunnable(), 1, 3, TimeUnit.SECONDS);


	}
}
