package executor.demo1.test.run;

import java.util.concurrent.*;

public class Run1 {
    // 获取基本属性
    public static void main(String[] args) {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(7, 8, 5, TimeUnit.SECONDS,
                new LinkedBlockingQueue<Runnable>());
        System.out.println(executor.getCorePoolSize()); //标准线程数
        System.out.println(executor.getMaximumPoolSize());//最大线程数
        System.out.println(executor.getPoolSize());//当前线程数
        System.out.println(executor.getQueue().size());//队列中的数
        System.out.println("===========================");

        executor = new ThreadPoolExecutor(7, 8, 5, TimeUnit.SECONDS,
                new SynchronousQueue<Runnable>());
        System.out.println(executor.getCorePoolSize());
        System.out.println(executor.getMaximumPoolSize());
        System.out.println(executor.getPoolSize());
        System.out.println(executor.getQueue().size());
    }

}
