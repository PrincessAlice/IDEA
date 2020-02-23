package task;

import java.io.File;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

public class FileScanner {

    /**
     * 1.核心线程数：始终运行的线程数量
     * 2.最大线程数：有新任务，并且当前运行线程数小于最大线程数，会创建新的线程来处理任务（正式工+临时工）
     * 3-4.超过3这个数量，4这个时间单位，2-1（最大线程数-核心线程数）这些线程（临时工）就会关闭
     * 5.工作的阻塞队列
     * 6.如果超出工作队列的长度，任务要处理的方式（4种策略需要大家知道）
     */

    private ThreadPoolExecutor pool = new ThreadPoolExecutor(
            3,3,0, TimeUnit.MICROSECONDS,
            new LinkedBlockingDeque<>(),new ThreadPoolExecutor.AbortPolicy()
    );

    //之前多线程讲解的方法是一种快捷的创建方式
    private ExecutorService pool = Executors.newFixedThreadPool(4);

    //计算器，不传入数据，表示初始化的值为0
    private volatile AtomicInteger count = new AtomicInteger();

    //线程等待的锁对象
    private Object lock = new Object();//第一种：synchronized(Lock)进行wait等待

    private CountDownLatch latch = new CountDownLatch(1);//第二种：await()阻塞等待直到latch =0
    private Semaphore semaphore = new Semaphore(0);//第三种实现：acquire()阻塞等待一定数量的

    private
    /**
     * 扫描文件目录
     * 最开始，不知道有多少子文件夹，不知道应该启动多少个线程
     */

    private void doScan(File dir) {
        pool.execute(new Runnable(){
            @Override
            public void run(){
                try {
                    callback.callback(dir);//文件保存操作
                    File[] children = dir.listFiles();//下一级文件和文件夹
                    if (children != null) {
                        for (File child : children) {//如果是文件夹，递归处理
                            if (child.isDirectory()) {//启动了文件夹扫描任务，计数器++i
           //                     System.out.println("文件夹" + child.getPath());
                                count.incrementAndGet();
                                System.out.println("当前任务数："+count.get());
                                doScan(child);
                            }
                        }
                    }
                } finally {//保证线程技术不管是否出现异常，都能够进行-1操作
                    int r = count.decrementAndGet();
                    if (r == 0) {
                        /** 第一种实现
                        synchronized (lock) {
                            lock.notify();
                        }
                         */
                        //第2种实现
 //                       latch.countDown();
                        //第3种实现
                        semaphore.release();
                    }
                }
            }
        });
    }

    public void scan(){

    }

    public void waitFinish() throws InterruptedException{
        /**
         * 第一中实现
         * synchronized (lock){
         *             lock.wait();
         *  }
         * 第二中实现
         *  latch.await();
         */

        try {
            //第二种实现
            semaphore.acquire();
        }finally{
            //
            System.out.println("关闭线程池...");
            //
   //         pool.shutdown();
            pool.shutdownNow();
        }
    }

    public static void main(String[] args){

    }
}
