package thread_learning4;



public class SynchronizedTest {

    public synchronized  static void method1(){
        System.out.println(Thread.currentThread().getName());
        while(true){

        }
    }

    public synchronized  static void method2(){
        System.out.println(Thread.currentThread().getName());
        while(true){

        }
    }

  /*  public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                method1();
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                method1();
            }
        }).start();
    }
*/
    public static void main(String[] args) {
        MyObject object1 = new MyObject();
        MyObject object2 = new MyObject();
        new Thread(new Runnable() {
            @Override
            public void run() {
                object1.method1();
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                object2.method2();
            }
        }).start();

    }


}

class  MyObject{
    public  synchronized static void method1(){
        System.out.println(Thread.currentThread().getName());
        while(true){

        }
    }

    public synchronized static void method2(){
        System.out.println(Thread.currentThread().getName());
        while(true){

        }
    }

}
