package executor.demo6.test.run.abortPolicy;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
/**
 * 当任务添加到线程池中被拒绝时，抛出RejectExecutionException异常
 */
public class Run {

    public static void main(String[] args) throws InterruptedException {
        Runnable runnable = new Runnable() {
            public void run() {
                try {
                    Thread.sleep(5000);
                    System.out.println(Thread.currentThread().getName()
                            + " run end!");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        //这里面的有界队列，表示队列只能放2个任务
        //该策略会直接抛出异常
        // ArrayBlockingQueue: 有界队列
        ThreadPoolExecutor executor = new ThreadPoolExecutor(2, 3, 10, TimeUnit.SECONDS,
                new ArrayBlockingQueue(2), new ThreadPoolExecutor.AbortPolicy());
        executor.execute(runnable);// 不报错
        executor.execute(runnable);// 不报错
        executor.execute(runnable);// 不报错 : 超过corePoolSize的时候，放入有界队列
        executor.execute(runnable);// 不报错
        executor.execute(runnable);// 不报错 ：当线程不大于maximumPoolSize的时候,创建新线程执行
        System.out.println(executor.getCorePoolSize()); //标准线程数
        System.out.println(executor.getMaximumPoolSize());//最大线程数
        System.out.println(executor.getPoolSize());//当前线程数
        System.out.println(executor.getQueue().size());//队列中的数
        executor.execute(runnable);// 报错 , 不能在创建新线程了
    }
}
