package thread_learning5;
/*
 * 三个线程A,B,C，分别打印字符串A,B,C
 * 要求：循环打印10次
 *   打印结果：
 *   ABC
 *   ABC
 *   ABC
 *   ...
 *   以上总共10次
 * */

public class SequencePrint2 {
    private volatile static String[] INFOS = {"A","B","C"};
    private  volatile  static String INDEX ;

    public static void main(String[] args) {
        Thread a = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    for(int i = 0;i < 10;i++){
                        synchronized (SequencePrint.class){
                            while(!INDEX .equals("A")){
                                SequencePrint.class.wait();
                            }
                            System.out.println(INDEX);
                            //name = "B";

                            SequencePrint.class.notifyAll();
                        }
                        System.out.println("A");
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        });
    }
}
