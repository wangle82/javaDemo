package phaser.demo2.tools;

import java.util.Date;
import java.util.concurrent.Phaser;

public class PrintTools {

    public static Phaser phaser;

    public static void methodA() {
        try {
            System.out.println(Thread.currentThread().getName() + " 斗地主加入=" + new Date(System.currentTimeMillis()) );
            phaser.arriveAndAwaitAdvance();

            Thread.sleep(10000);
            phaser.arriveAndAwaitAdvance();
            System.out.println(Thread.currentThread().getName() + " 游戏关闭=" + new Date(System.currentTimeMillis()));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public static void methodB() {
        try {
            Thread.sleep(5000);
            System.out.println(Thread.currentThread().getName() + " 斗地主加入=" + new Date(System.currentTimeMillis()));
            phaser.arriveAndAwaitAdvance();
            Thread.sleep(2000);
            System.out.println(Thread.currentThread().getName() + " 退出加入=" + new Date(System.currentTimeMillis()));
            phaser.arriveAndDeregister();// 使当前线程退出，并使屏障计数减1
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
