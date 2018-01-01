package phaser.demo1.tools;

import java.util.Date;
import java.util.concurrent.Phaser;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class PrintTools {

    public static Phaser phaser;

    /**
     * phaser 可以支持多个阶段的同步
     */
    public static void methodA() {
        try {
            //第一个阶段 : 为了执行效果
            if ("皇马".equals(Thread.currentThread().getName())) {
                Thread.sleep(4000);
            } else {
                Thread.sleep(2000);
            }
            System.out.println(Thread.currentThread().getName() + " 上半场入场=" + new Date(System.currentTimeMillis()));
            phaser.arriveAndAwaitAdvance(); // 效果类似于CyclicBarrier的await() : 必须等到两个线程同时达到这个，才往下进行
//            phase 从0开始，当所有的已注册的parties都到达后（arrive）将会导致此phase数字自增（advance）, 在onAdvance方法执行完，继续往下阶段执行
            Thread.sleep(2000);
            System.out.println(Thread.currentThread().getName() + " 上半场比赛=" + new Date(System.currentTimeMillis()) + "阶段 = " + phaser.getPhase());

            //第二个阶段
            if ("皇马".equals(Thread.currentThread().getName())) {
                Thread.sleep(2000);
            } else {
                Thread.sleep(4000);
//                Thread.sleep(4000000); //测试等于onadvance等于true的时候，设置比较大的值, 不需要等其他线程
            }
            System.out.println(Thread.currentThread().getName() + " 下半场入场=" + new Date(System.currentTimeMillis()));
            phaser.arriveAndAwaitAdvance();

            Thread.sleep(2000);
            System.out.println(Thread.currentThread().getName() + " 下半场比赛=" + new Date(System.currentTimeMillis()) + "阶段 = " + phaser.getPhase());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
