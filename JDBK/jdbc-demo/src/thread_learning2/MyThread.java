package thread_learning2;

public class MyThread {
    public static void main(String[] args) throws InterruptedException {

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("明天就要剁手");
            }
        });
        thread.start();
        //不调用join时，创建线程会耗时比较长，下边的main方法的代码会先执行
        thread.join();

        //下边代码常常先执行，因为以上创建线程部分很耗时
        System.out.println("今天还是要上课");
    }
}
