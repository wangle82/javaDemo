package phaser.demo3.test;

import phaser.demo3.extthread.MyThread;

import java.util.concurrent.Phaser;


public class Run {
    public static void main(String[] args) throws InterruptedException {
        Phaser phaser = new Phaser(7);
        System.out.println("总数 " + phaser.getRegisteredParties());
        MyThread[] myThreadArray = new MyThread[5];
        for (int i = 0; i < myThreadArray.length; i++) {
            myThreadArray[i] = new MyThread(phaser);
            myThreadArray[i].setName("Thread" + (i + 1));
            myThreadArray[i].start();
        }
        Thread.sleep(2000);

        phaser.register(); //可以动态新增1个Parties的数量

        phaser.bulkRegister(5); //可以批量增加数量

        System.out.println("总数 " + phaser.getRegisteredParties());

        //到达和未到达
        System.out.println("已到达：" + phaser.getArrivedParties());
        System.out.println("未到达：" + phaser.getUnarrivedParties());

        MyThread[] myThreadArray2 = new MyThread[8];
        for (int i = 0; i < myThreadArray2.length; i++) {
            myThreadArray2[i] = new MyThread(phaser);
            myThreadArray2[i].setName("Thread" + (i + 1));
            myThreadArray2[i].start();
        }
        Thread.sleep(5000);

        //线程执行完成: 在记录一下: Arrived和Unarrived会重新设置
        System.out.println("已到达：" + phaser.getArrivedParties());
        System.out.println("未到达：" + phaser.getUnarrivedParties());
    }
}
