package learning7;

import java.util.Timer;
import java.util.TimerTask;

public class TimerTest {
    public static void main(String[] args) {
        //原生实现Timer
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("我来了");
            }
        },0,1000);
    }
}
