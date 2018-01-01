package futureAndcallable.demo2.mycallable;

import java.util.concurrent.Callable;

public class MyCallable implements Callable<String> {

    @Override
    public String call() {
        for (; ;) {
            if (Thread.currentThread().isInterrupted()) {
                System.out.println("任务中断");
                break;
            } else {
                System.out.println("任务进行");
            }
        }
        return "任务完成";
    }
}
