package task;

import java.io.File;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;

public class FileScanner {
    private volatile AtomicInteger count = new AtomicInteger();

    //线程等待的锁对象
    private Object lock = new Object();//第一种：synchronized(Lock)进行wait等待

    private CountDownLatch latch = new CountDownLatch(1);//第二种：await()阻塞等待直到latch =0
    private Semaphore semaphore = new Semaphore(0);//第三种实现：acquire()阻塞等待一定数量的

    /**
     * 扫描文件目录
     * 最开始，不知道有多少子文件夹，不知道应该启动多少个线程
     */

    private void doScan(File dir) {
        pool.execute(new Runnable(){
            @Override
            public void run(){
                try {
                    callback.callback(dir);
                    File[] children = dir.listFiles();
                    if (children != null) {
                        for (File child : children) {
                            if (child.isDirectory()) {
           //                     System.out.println("文件夹" + child.getPath());
                                count.incrementAndGet();
                                doScan(child);
                            }
           //                 else {
                                //TODO
           //                     System.out.println("文件" + child.getPath());
          //                  }
                        }
                    }
                } finally {
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


    public static void main(String[] args){

    }
}
