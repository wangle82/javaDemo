package cyclicbrarrier.demo4.test;

import cyclicbrarrier.demo4.extthread.MyThread;
import cyclicbrarrier.demo4.service.MyService;

import java.util.concurrent.CyclicBarrier;


public class Run {

    public static void main(String[] args) throws InterruptedException {
        int parties = 4;
        CyclicBarrier cbRef = new CyclicBarrier(parties, new Runnable() {
            public void run() {
                System.out.println("都到了!");
            }
        });

        MyService myService = new MyService(cbRef);
        MyThread[] threadArray = new MyThread[4];
        for (int i = 0; i < threadArray.length; i++) {
            threadArray[i] = new MyThread(myService);
            threadArray[i].start();
            if (threadArray[i].getName().equals("Thread-2")){
                Thread.sleep(1000);
                threadArray[i].interrupt();
            }
        }
    }
}
