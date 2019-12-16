package learning7;

import java.util.concurrent.PriorityBlockingQueue;

//基于阻塞式队列的定时器
public class TimerTest2 {
    public static void main(String[] args) {
        MyTimer20 timer20 = new MyTimer20();
        timer20.schedule(new Runnable() {
            @Override
            public void run() {
                System.out.println("我来啦");
            }
        },0,1000);

        timer20.schedule(new Runnable() {
            @Override
            public void run() {
                System.out.println("我去了");
            }
        },0,1000);
    }

}
//设计一个类，定义一些功能，其他人也可以使用(封装类)
class MyTimer20{
    //static静态覆写，final防止被修改
    private static final PriorityBlockingQueue<Timer2Task> QUEUE = new PriorityBlockingQueue<>();

    public MyTimer20(){
        try {
            while(true){
                //调用take()阻塞方法，队列为空就等待
                Timer2Task task = QUEUE.take();
                long current = System.currentTimeMillis();
                //任务时间没有到，就等待，因为从队列中已经取出来了，所以要放回去
                if(task.getNext()>current){
                    QUEUE.offer(task);
                    synchronized (QUEUE) {
                        //wait  or sleep 进行等待
                        //等待时间差
                        QUEUE.wait(task.getNext() - current);
                    }
                }else{
                    //时间到了，可以先执行
                    task.getTask().run();
                    //间隔时间>0，更新下次执行的任务时间，并放回队列
                    if(task.getPeriod() >0){
                        //修改执行时间
                        task.setNext(task.getNext() + task.getPeriod());
                        QUEUE.offer(task);
                    }else{
                        break;
                    }
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    /*
    * 提供给其他地方使用，为了方便使用，尽可能的把参数简单化
    * @param task 定时任务
    * @param delay 延时时间
    * @param period 间隔时间
    */

    public void schedule(Runnable task,long delay,long period){
        //在队列中获取任务时，需要使用传入参数。所以考虑设计自定义的定时任务类
        QUEUE.offer(new Timer2Task(task,delay,period));
        synchronized (QUEUE){
            QUEUE.notify();
        }
    }
}

class Timer2Task implements  Comparable<Timer2Task>{

    private Runnable task;
    //下次任务的执行时间
    private long next;
    //间隔时间
    private long period;
    public Timer2Task(Runnable task, long delay, long period) {
        this.task= task;
        this.next = System.currentTimeMillis() + delay;
        this.period = period;
    }

    @Override
    public int compareTo(Timer2Task o){
        return Long.compare(next,o.next);
    }

    public Runnable getTask() {
        return task;
    }

    public long getNext() {
        return next;
    }

    public long getPeriod() {
        return period;
    }

    public void setNext(long next) {
        this.next = next;
    }
}