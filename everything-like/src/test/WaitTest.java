package test;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;

public class WaitTest {
    /**
     * 等待所有线程执行完毕；
     *1.CountDownLatch:初始化一个数值，可以countDown()对数值进行i--操作,
     * 2.Semaphone: 使用release()进行一定数量许可的颁发，acquire()阻塞并等待一定数量的许可
     */

    private static int COUNT = 5;
    private static CountDownLatch LATCH = new CountDownLatch(COUNT);
    private static Semaphore SEMAPHORE = new Semaphore(5);

    public static void main(String[] args) throws InterruptedException {
        for(int i =0;i<COUNT;i++){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName());
 //                   LATCH.countDown(); //i--
                    SEMAPHORE.release(); //强调一定数量许可证
                }
            }).start();
        }
  //      LATCH.await();
        SEMAPHORE.acquire(5);//无参代表请求
        System.out.println(Thread.currentThread().getName());
    }
}
