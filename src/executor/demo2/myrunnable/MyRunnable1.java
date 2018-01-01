package executor.demo2.myrunnable;

import java.util.Date;

public class MyRunnable1 implements Runnable {
    public void run() {
        try {
            System.out.println("begin " + Thread.currentThread().getName() + "" + new Date(System.currentTimeMillis()));
            Thread.sleep(4000);
            System.out.println("  end " + Thread.currentThread().getName() + "" + new Date(System.currentTimeMillis()));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
