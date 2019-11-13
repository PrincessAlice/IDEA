package thread_learning3;

public class UnsafeThread {

    public static int COUNT;

    public static void main(String[] args) {
       //开启20个线程，每个线程对COUNT进行++操作10000次
        //预期结果：200000
        //法一：双循环
        for(int i = 0;i < 20;i++) {
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int j = 0; j < 10000; j++) {
                        COUNT++;
                        System.out.println(COUNT);
                    }
                }
            });
            thread.start();
        }

        //法二：数组循环
        Thread[] thread2 = new Thread[20];
        for(int i = 0;i < 20;i++){
            thread2[i] = new Thread(new Runnable() {
                @Override
                public void run() {
                    for(int j = 0;j < 10000;j++){
                        COUNT++;
                        System.out.println(COUNT);
                    }
                }
            });
            thread2[i].start();
        }

        //法三：yield 线程让步
        for(int i = 0;i < 20;i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int j = 0; j < 10000; j++) {
                        COUNT++;

                    }
                }
            }).start();
        }
        while(Thread.activeCount() >1){
            Thread.yield();
        }
        System.out.println(COUNT);

    }
}
