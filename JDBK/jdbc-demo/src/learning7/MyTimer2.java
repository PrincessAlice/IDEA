package learning7;

import java.util.concurrent.PriorityBlockingQueue;

//基于阻塞式队列来做定时器
public class MyTimer2 {
    private PriorityBlockingQueue<MyTimerTask> queue = new PriorityBlockingQueue<>();

    public MyTimer2(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                while(true){
                    MyTimerTask task =queue.poll();
                    long current = System.currentTimeMillis();
                    if(task.getNext()> current){

                    }
                }
            }
        }).start();
    }
    public void schedule(Runnable task,long delay,long period){
        queue.offer(new MyTimerTask(delay,period));
    }
}

//设计一个类，定义一些功能，其他人也可以使用
class MyTimerTask implements Comparable<MyTimerTask>{
    private long next;
    private long period;

    public MyTimerTask(long next,long period){
        this.next = System.currentTimeMillis()+ next;
        this.period = period;
    }

    @Override
    public int compareTo(MyTimerTask o){
        return Long.compare(next,o.next);
    }

    public long getNext() {
        return next;
    }
}

