package thread_learning3;

import java.util.ArrayList;
import java.util.List;

public class UnsafeThread2 {
    public static int COUNT;
    public static void main(String[] args) {

        List<Integer> list = new ArrayList<>();

        for(int i = 0;i < 20;i++) {
            final  int k = i;
            new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int j = 0; j < 10000; j++) {
                        COUNT++;
                        list.add(k*10000+j);
                    }
                }
            }).start();
        }
        while(Thread.activeCount() >1){
            Thread.yield();
        }
        System.out.println(list.size());

    }
}
