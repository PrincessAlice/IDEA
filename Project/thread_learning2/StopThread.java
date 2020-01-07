package thread_learning2;

public class StopThread {


    private static volatile boolean myInterrupted;
    //volatile 专用于多线程，严谨的写法  保证多线程线程的可见性、顺序性

    //线程是否被中断，默认为TRUE

    public static void main(String[] args) throws InterruptedException {
        new Thread(new Runnable() {
            @Override
            public void run() {
                while(!myInterrupted){
                    System.out.println("yes");
                    try {
                        Thread.sleep(1000);  //休息一秒在打印
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
        Thread.sleep(5000);  //阻塞5秒，再向下执行
        myInterrupted = true; //保留语义，默认true
    }
}
