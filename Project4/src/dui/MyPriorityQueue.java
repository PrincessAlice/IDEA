package dui;

//优先队列
public class MyPriorityQueue {
    //先不考虑array存不下数据的情况
    private int[] array = new int[100];
    private int size = 0;

    //O(log(n))
    public void add(int element){
        array[size++] = element;
        Heaps.adjustUP(array,size-1);
    }

    //O(log(n))
    public int poll(){
        int e = array[0];
        array[0] = array[--size];
        Heaps.heapify(array,size,0);
        return e;
    }

    //O(1)
    public int peek(){
        return array[0];
    }
}
