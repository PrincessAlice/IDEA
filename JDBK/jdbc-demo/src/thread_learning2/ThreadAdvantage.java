package thread_learning2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class ThreadAdvantage {
    /**
     * 集合：
     * Collection    (List:ArrayList 数组 ,LinkedList 队列 链表),
     *               (Set:HashSet 基于HashMap 数组 链表红黑树 实现,TreeSet )
     * Map       (HashMap 数组 链表 红黑树,TreeMap )
     * @param  args
     * */

    //初始化链表
    public static List<String> randomList(){
        //创建随机字符串（回忆随机数）
        char[] chars ={'a','b','c','z','A','Z'};
        List<String> list = new LinkedList<>();
        for(int i = 0;i < 10_0000;i++){
            int random = new Random().nextInt(chars.length);
            char c = chars[random];
            list.add(String.valueOf(c));
        }
        return  list;
    }

    public static void main(String[] args) throws InterruptedException {
        List<String> list = randomList();
        //创建10个线程，每个线程获取list中的10000个元素
        //时间 java.util.Date
        //jdk 1.8 ——>Local
        long start =  System.currentTimeMillis();
        //long start = new Date().getTime();
        Thread[] threads = new Thread[10];
        for(int i=0;i<10;i++) {
            //通过final变量来获取 i
            final int k = i;
            threads[i] = new Thread(new Runnable() {
                @Override
                public void run() {
                    Thread current = Thread.currentThread();
                    System.out.println("id="+ current.getId() + " name=" +current.getName());
                   // System.out.println(Thread.currentThread().getName());
                    System.out.println(threads[k].getName());
                    for(int j = 0;j < 10000;j++){
                        list.get(k*10000+j);
                    }
                }
            },"我的线程" +k);
            threads[i].start();
        }
        //第一种做法：线程让步 yield
        /*while(Thread.activeCount()>1){
        *   Thread.yield();
        * }
        */
        //第二种做法:调用线程加入/等待 join
        for(Thread thread:threads){
            thread.join();
        }
        long end = System.currentTimeMillis();
        System.out.println("耗时："+(end - start) + "毫秒");
    }
}
