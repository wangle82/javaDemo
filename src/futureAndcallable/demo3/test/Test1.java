package futureAndcallable.demo3.test;

import futureAndcallable.demo3.mycallable.MyCallable;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;


public class Test1 {
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

            ThreadPoolExecutor executor = new ThreadPoolExecutor(5, 10, 5, TimeUnit.SECONDS, new LinkedBlockingDeque<Runnable>());
            CompletionService completionService = new ExecutorCompletionService(executor);

            //一边提交任务
            for (int i = 0; i < 5; i++) {
                System.out.println("提交第" + (i + 1) + "个任务");
                completionService.submit(callableList.get(i));
            }
            //一边获得任务的结果;那个完成，那个打印,不会造成整体的阻塞
            for (int i = 0; i < 5; i++) {
                System.out.println("等待打印第" + (i + 1) + "个返回值");// 拿到最先完成的任务的返回值，而不管它们加入线程池的顺序
                System.out.println(completionService.take().get());
            }
            executor.shutdown();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
