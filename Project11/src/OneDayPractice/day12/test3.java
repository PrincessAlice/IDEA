package OneDayPractice.day12;

//生成格雷码

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class test3 {

    public  String[] getGray(int n) {
        Queue<StringBuilder> queue = new LinkedList<>();
        getGray(n,queue);
        String[] res = new String[queue.size()];
        int i = 0;
        while ( !queue.isEmpty()){
            res[i] = queue.poll().toString();
            i++;
        }
        return res;
    }

    public void getGray(int n, Queue<StringBuilder> queue){

        if( n == 1){
            queue.add(new StringBuilder().append(0));
            queue.add(new StringBuilder().append(1));
            return;
        }
        getGray(n-1,queue);
        int size = queue.size();
        while (size > 0){
            int i;
            i = size & (byte)1;
            StringBuilder poll = queue.poll();
            StringBuilder nextSb = new StringBuilder(poll);
            poll.append(i);
            nextSb.append(1-i);
            queue.offer(poll);
            queue.offer(nextSb);
            size --;
        }
    }


    public static void main(String[] args) {
        test3 gerryCode = new test3();
        System.out.println(Arrays.toString(gerryCode.getGray(3)));
    }
}
