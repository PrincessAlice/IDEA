package thread_learning4;


public class SafeThread {
    //开启20个线程，每个线程对COUNT进行++操作10000次
    //预期结果：200000
    public static int COUNT;

    public static void main(String[] args) {

        //  Object object = new Object();
        //法三：yield 线程让步
        for (int i = 0; i < 20; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int j = 0; j < 10000; j++) {
                        //COUNT ++;
                        //COUNT --;
                        //对静态类对象锁定
                        increment();
                        decrement();

                        //对实例对象锁定
                        //  synchronized (object){
                        //      COUNT++;
                        // }
                    }
                }
            }).start();
        }
        while (Thread.activeCount() > 1) {
            Thread.yield();
        }
        System.out.println(COUNT);
    }


    public synchronized static void increment(){   //关键词synchronized 必须放在访问权限修饰符之后 同步的
      COUNT ++;
    }

    //与上面静态同步方法相同，锁的对象相同
  //  public static void increment(){
  //      synchronized (SafeThread.class) {
 //           COUNT++;
  //      }
 //   }

    public synchronized static void decrement(){
        COUNT--;
    }

    public void increment2(){

    }

    public void increment3(){ //2 3等同
        synchronized (this){

        }
    }

}
