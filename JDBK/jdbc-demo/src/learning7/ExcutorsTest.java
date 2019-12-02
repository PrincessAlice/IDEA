package learning7;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExcutorsTest {
    //单个线程
   // private static final ExecutorService EXE = Executors.newSingleThreadExecutor();
    //5个线程大小的线程池
   private static final ExecutorService EXE = Executors.newFixedThreadPool(5);
    //可以缓存的线程
    //private static final ExecutorService EXE = Executors.newCachedThreadPool();
   //
    // private static final ExecutorService EXE = Executors.newScheduledThreadPool();
    public static void main(String[] args) {
        for(int i = 0;i<100;i++){
            final int j = i;
            EXE.submit(new Runnable() {
                @Override
                public void run() {
                    while(true){
                        System.out.println(j);
                        try {
                            Thread.sleep(3000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            });
        }
        //手动调用关闭线程
//        EXE.shutdown();

    }
}
