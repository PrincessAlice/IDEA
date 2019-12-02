package learning7;

public class MyTimer {
    public static void main(String[] args) {
        new MyTimer().schedule(new Runnable() {
            @Override
            public void run() {
                System.out.println("我来啦");
            }
        },0,1000);
    }

    public void schedule(Runnable task,long delay,long period){
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    long next = System.currentTimeMillis() + delay;
                    while(true){
                        long current = System.currentTimeMillis();
                        if(next > current){
                            Thread.sleep(next-current);
                        }
                        new Thread(task).run();
                        if(period > 0){
                            next += period;
                        }else {
                            break;
                        }
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
