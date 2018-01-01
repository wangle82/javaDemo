package executor.demo1.test.run;

import java.util.Date;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Run3_3 {
    // 队列使用SynchronousQueue类
    // 并且线程数量>=corePoolSize
    // 并且线程数量<=maximumPoolSize
    // 并且keepAliveTime值为0时作用是线程执行完毕后立即清除
    public static void main(String[] args) throws InterruptedException {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println(Thread.currentThread().getName()
                            + " run!!!!" + new Date(System.currentTimeMillis()));
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        // 当线程数量大于corePoolSize值时候，在没有超过指定的时间内是不从线程池中将空闲线程删除的，
        // 如果超过此时间单位，则删除，如果设为0则任务执行完成后立即从队列中删除
        ThreadPoolExecutor executor = new ThreadPoolExecutor(7, 10, 0L,
                TimeUnit.MILLISECONDS, new SynchronousQueue<Runnable>());
        executor.execute(runnable);// 1
        executor.execute(runnable);// 2
        executor.execute(runnable);// 3
        executor.execute(runnable);// 4
        executor.execute(runnable);// 5
        executor.execute(runnable);// 6
        executor.execute(runnable);// 7
        executor.execute(runnable);// 8
        executor.execute(runnable);// 9

        System.out.println("A:" + executor.getCorePoolSize());
        System.out.println("A:" + executor.getPoolSize());
        System.out.println("A:" + executor.getQueue().size());
        Thread.sleep(2000);
        System.out.println("=============查看线程池中的线程数量=============");
        System.out.println("B:" + executor.getCorePoolSize());
        System.out.println("B:" + executor.getPoolSize());
        System.out.println("B:" + executor.getQueue().size());
        executor.shutdown();
    }
}
