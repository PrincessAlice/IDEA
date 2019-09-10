package Paixu;

import java.util.List;

public class MyArrayList<E> {
    private E[] array;
    private int size;

    @SuppressWarnings("unchecked")
    public MyArrayList(){
        //了解：1.泛型无法定义数组
        //压制警告的注解
        array = (E[])new Object[100];
        size = 0;
    }

    public void add(E element){
        array[size++] = element;
    }

    public void remove(){
        array[--size] = null;
        //size--; 这种写法会引发内存泄漏
        //原本语义上应该死去的对象，因为写法问题，导致没有被GC判定为死掉
        //Java中出现的内存泄漏问题
    }

    public static void print(MyArrayList<Object>list){
    }

    public static void printList(List<?>list){

    }
}
