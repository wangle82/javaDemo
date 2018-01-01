package phaser.demo1.test;

import phaser.demo1.extthread.ThreadA;
import phaser.demo1.extthread.ThreadB;
import phaser.demo1.tools.PrintTools;

import java.util.concurrent.Phaser;

public class Run {
    public static void main(String[] args) throws InterruptedException {
        Phaser phaser = new Phaser(2) {
            protected boolean onAdvance(int phase, int registeredParties) {
                if (registeredParties == 2) {
                    System.out.println("球队都入场");
                }
                //第一次进入是0
                if (phase == 0) {
                    System.out.println("投硬币，选场地！");
                } else if (phase == 1) {
                    System.out.println("换场地！");
                } else {
                    System.out.println("颁奖完成！");
                }
                //return true;
                return false;
                // 返回true不等待了，不用等所有线程都到的时间执行，Phaser呈无效/销毁的状态
                // 返回false则Phaser继续工作
            }
        };
        PrintTools.phaser = phaser;
        ThreadA a = new ThreadA(phaser);
        a.setName("巴萨");
        a.start();

        ThreadB b = new ThreadB(phaser);
        b.setName("皇马");
        b.start();
    }
}
