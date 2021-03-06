package se.reveiw2;

import java.util.Random;

public class MessageQueue {
    private int[] items;
    private int putIndex;
    private int takeIndex;
    private volatile int size;

    public MessageQueue(int capacity) {
        items = new int[capacity];
        putIndex =0;
        takeIndex =0;
        size =0;
    }
    public void put(int message) throws InterruptedException {
        do {
            synchronized (this) {
                if (size < items.length) {
                    items[putIndex]= message;
                    putIndex =(putIndex + 1) % items.length;
                    size++;
                    notifyAll();
                    return;
                }
            }
            while (size == items.length) {
                synchronized (this) {
                    if (size == items.length) {
                        wait();
                    }
                }
            }
        } while (true);
    }
    public int take() throws InterruptedException {
        do {
            synchronized (this) {
                if (size > 0) {
                    int message = items[takeIndex];
                    takeIndex =(takeIndex + 1) % items.length;
                    size--;
                    notifyAll();
                    return message;
                }
            }
            while (size ==0) {
                synchronized (this) {
                    if (size ==0) {
                        wait();
                    }
                }
            }
        } while (true);
    }
    public synchronized int size() {
        return size;
    }
    public static void main(String[] args) {
        MessageQueue queue = new MessageQueue(100000);
        Thread producer = new Thread(()->{
            Random random = new Random();
            try {
                for (int i =0; i < 1000000000; i++) {
                    queue.put(random.nextInt(100000));
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"生产者");
        Thread customer = new Thread(()-> {
            try {
                while (true) {
                    int message = 0;
                    message = queue.take();
                    System.out.println(message);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"消费者");
    }
}