package countDownLatch.demo2.test;

import countDownLatch.demo2.extthread.MyThread;

import java.util.concurrent.CountDownLatch;

public class Run {

    public static void main(String[] args) {
        try {
            CountDownLatch comingTag = new CountDownLatch(10);
            CountDownLatch waitTag = new CountDownLatch(1);
            CountDownLatch waitRunTag = new CountDownLatch(10);
            CountDownLatch beginTag = new CountDownLatch(1);
            CountDownLatch endTag = new CountDownLatch(10);
            System.out.println("裁判员在等待选手的到来！");
            MyThread[] threadArray = new MyThread[10];
            for (int i = 0; i < threadArray.length; i++) {
                threadArray[i] = new MyThread(comingTag, waitTag, waitRunTag, beginTag, endTag);
                threadArray[i].start();
            }
            comingTag.await();//等减到0 才继续执行
            System.out.println("裁判看到所有运动员来了,喊各就各位！");
            waitTag.countDown();
            waitRunTag.await();
            Thread.sleep(2000);
            System.out.println("发令枪响起！");
            beginTag.countDown();
            endTag.await();
            System.out.println("所有运动员到达，统计比赛名次！");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

}
