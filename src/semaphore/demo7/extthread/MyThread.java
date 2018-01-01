package semaphore.demo7.extthread;


import semaphore.demo7.service.Service;

public class MyThread extends Thread {

    private Service service;

    public MyThread(Service service) {
        super();
        this.service = service;
    }

    @Override
    public void run() {
        service.sayHello();
    }
}
