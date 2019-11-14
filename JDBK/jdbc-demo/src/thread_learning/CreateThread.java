package thread_learning;

public class CreateThread {
    public static void main(String[] args) {
        //继承thread 类
        MyTread t = new MyTread();
      //  t.start();
        //实现Runnable 接口
        Runnable runner = new MyRunner();
        //CreateThread t1 = new CreateThread(runner);  //Runnable tmp = runner
       // t1.start();
        //javaMain是java层面的主线程，和main方法中自行创建的线程是同级的
        while (true) {}

    }

}

    //public abstract void run();

    //创造线程第一种：继承自thread 类  重写run方法
    class MyTread extends CreateThread {
      //  @Override
        public void run(){
            System.out.println("in thread");
        }


    }

    //第二种：实现Runnable 接口   重写run方法
    class MyRunner implements Runnable{
        @Override
        public void run(){
            System.out.println("in thread");
        }
    }
