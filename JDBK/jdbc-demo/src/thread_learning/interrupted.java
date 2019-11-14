package thread_learning;

public class interrupted {
    //测试当前线程是否中断

    public static void main(String[] arg) {

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i=0;i<5;i++){
                    System.out.println(Thread.currentThread().isInterrupted());
                }
                try {
                    //调用sleep()/wait()/join()方式时，线程进入阻塞状态，
                    // 此时也是可以中断的，中断后抛出InterruptedException
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                for(int i=0;i<5;i++){
                    System.out.println(Thread.currentThread().isInterrupted());
                }
            }
       });
        thread.start();
       // Thread.sleep(1000);

        //优势在于可以中断wait()/join()/sleep()的阻塞线程
        thread.interrupt();


       /* Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i=0;i<10;i++){
                    // boolean tmp = 标志位；
                    //标志位 = false;
                    //return tmp;
                    //作用：重置标志位为false，并且返回之前的标志位
                   boolean b = Thread.interrupted();

                    //isInterrupted 获取当前标志位
                   // boolean b = Thread.currentThread().isInterrupted();
                    System.out.println(b);
                }
            }
        });
        //线程创建之后标志位 = false;
        thread2.start();
        thread2.interrupt();   //修改标志位 = true;
    */

    }
}
