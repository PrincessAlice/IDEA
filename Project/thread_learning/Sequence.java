package thread_learning;

public class Sequence {
    public static void main(String[] args) {
        //启动0-9 编号的 10个线程，每个线程打印他的编号

        for(int i = 0;i < 10;i++){
            final int j = i;
            Runnable r = new Runnable() {
                @Override
                public void run() {
                    System.out.println(j);

                    //sleep 休眠1秒打印
                    try {
                        Thread.sleep(1000);
                        System.out.println(j);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            };
            Thread t = new Thread(r);
            t.start();
        }
    }

}
