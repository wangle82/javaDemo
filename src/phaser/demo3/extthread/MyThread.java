package phaser.demo3.extthread;

import java.util.Date;
import java.util.concurrent.Phaser;

public class MyThread extends Thread {

    private Phaser phaser;

    public MyThread(Phaser phaser) {
        super();
        this.phaser = phaser;
    }

    public void run() {
        try {
            System.out.println(Thread.currentThread().getName() + "任务开始=" + new Date(System.currentTimeMillis()));
            phaser.arriveAndAwaitAdvance();
            Thread.sleep(1000);
            System.out.println(Thread.currentThread().getName() + "任务结束=" + new Date(System.currentTimeMillis()));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
