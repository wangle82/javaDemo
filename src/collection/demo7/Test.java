package collection.demo7;
/**
 * PriorityBlockingQueue存储的对象必须是实现Comparable接口的 因为PriorityBlockingQueue队列会根据内部存储的每一个元素的compareTo方法比较每个元素的大小
 这样在take出来的时候会根据优先级 将优先级最小的最先取出
 */
public class Test {
    public static void main(String[] args) throws InterruptedException {
        MyService myService = new MyService();
        ThreadA a = new ThreadA(myService);
        a.start();
        a.join();
        System.out.println(myService.queue.size());
    }
}
