package learning7;


//线程池
public class MyThreadPool {
    private MyBlockingQueue<Runnable> queue;

    private MyWorker[] workers;

    public MyThreadPool(int capacity,int size){
        workers  = new MyWorker[capacity];
        queue = new MyBlockingQueue<>(size);
        for(int i = 0;i<capacity;i++){
            workers[i] = new MyWorker(queue);
            workers[i].start();
        }
    }

    public void execute(Runnable task){
        //offer本身保证线程安全
        queue.offer(task);
    }
}

class MyWorker extends Thread{
    private MyBlockingQueue<Runnable> queue;

    public MyWorker(MyBlockingQueue queue){
        this.queue = queue;
    }
    @Override
    public void run(){
        while(true){
            Runnable task = queue.poll();
            //调用了一个实例方法，run() 等待上一个任务执行完成再执行
            task.run();
        }
  //   super.run();
    }
}