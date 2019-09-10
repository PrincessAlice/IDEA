package huan;

import java.util.Arrays;
import java.util.Random;


public class test2 {
    //冒泡排序
    public static void bubbleSort1(int[] array){
        for(int i = 0;i<array.length;i++){
            boolean sorted = true;
            for(int j= 0;j<array.length-i-1;j++){
                if(array[j] > array[j+1]){
                    swap(array,j,j+1);
                    sorted = false;
                }
            }
            if(sorted){
                break;
            }
        }
    }
    private static void swap(int[] array,int i,int j){
        int t = array[i];
        array[i] = array[j];
        array[j] = t;
    }
    private static int[] BuildRandomArray(int n){
        Random random = new Random(20190901);
        int[] array = new int[n];
        for(int i = 0;i < n;i++){
            array[i] =random.nextInt(n);
        }
        return array;
    }

    public static void main(String[] args) {
        int[] array = BuildRandomArray(10);
        System.out.println(Arrays.toString(array));
        System.out.println("================================");
        bubbleSort1(array);
        System.out.println(Arrays.toString(array));
    }
}
