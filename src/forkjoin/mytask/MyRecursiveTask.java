package forkjoin.mytask;

import java.util.concurrent.RecursiveTask;

public class MyRecursiveTask extends RecursiveTask<Integer> {

    private int beginPosition;
    private int endPosition;

    public MyRecursiveTask(int beginPosition, int endPosition) {
        super();
        this.beginPosition = beginPosition;
        this.endPosition = endPosition;
    }

    /**
     * 并行计算
     *
     * @return
     */
    protected Integer compute() {
        System.out.println("compute=" + beginPosition + " " + endPosition);
        if ((endPosition - beginPosition) != 0) {
            int middleNum = (endPosition + beginPosition) / 2;
            System.out.println("left  传入的值:" + (beginPosition + " " + middleNum));
            MyRecursiveTask leftTask = new MyRecursiveTask(beginPosition, middleNum);
            System.out.println("right 传入的值:" + ((middleNum + 1) + " " + endPosition));
            MyRecursiveTask rightTask = new MyRecursiveTask(middleNum + 1, endPosition);

            //每次使用invokeAll就是将任务进行分解
            this.invokeAll(leftTask, rightTask);
            Integer leftValue = leftTask.join();
            System.out.println("leftValue " + leftValue);
            Integer rightValue = rightTask.join();
            System.out.println("rightValue " + rightValue);
            System.out.println("每次计算结果 ： " + (leftValue + rightValue));
            return leftValue + rightValue;
        } else {
            return endPosition;
        }
    }
}
