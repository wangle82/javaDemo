package executor.demo6.test.run.callerRunsPolicy.extthread;

import java.util.Date;

public class MyThreadA extends Thread {

    @Override
    public void run() {
        try {
            Thread.sleep(5000);
            System.out.println("  end " + Thread.currentThread().getName() + " " + new Date(System.currentTimeMillis()));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
