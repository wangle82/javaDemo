package phaser.demo2.test;

import phaser.demo2.extthread.ThreadA;
import phaser.demo2.extthread.ThreadB;
import phaser.demo2.extthread.ThreadC;
import phaser.demo2.tools.PrintTools;

import java.util.concurrent.Phaser;


public class Run {
    public static void main(String[] args) {
        Phaser phaser = new Phaser(3) {
            protected boolean onAdvance(int phase, int registeredParties) {
                if (registeredParties != 3) {
                    System.out.println("游戏人数不到");
                } else {
                    System.out.println("开始游戏" );
                }
                return false;
            }
        };
        PrintTools.phaser = phaser;
        ThreadA a = new ThreadA(phaser);
        a.setName("A");
        a.start();

        ThreadB b = new ThreadB(phaser);
        b.setName("B");
        b.start();

        ThreadC c = new ThreadC(phaser);
        c.setName("C");
        c.start();
    }
}
