package practice;

public class test8 {
    public static void main(String[] args) {
        int[] x = new int[4];  //开辟了一个长度为4 的数组
        //分布进行数组实例化
        //int[] x = null;
       // x = new int[3];
        System.out.println(x.length);
        x[0] = 1;
        x[1] = 2;
        x[2] = 3;
        x[3] = 4;
        for(int i = 0;i < x.length;i++){
            System.out.println(x[i]); //通过循环控制索引下标更改
        }

        //方法接收数组
        int[] data = new int[]{1,2,3,4};
        bigger(data);
        printArray(data);
    }

    //定义一个返回数组的方法
    public static int[] init(){
        return new int[]{0,1,2,3,4,5,6};
    }
    //用方法修改数组
    public static void bigger(int[] arr){
        for(int i = 0;i <arr.length;i++){
            arr[i] *=5;  //每个元素扩大5倍
        }
    }
    //方法接收数组
    public static void printArray(int[] temp){
        for(int j = 0;j < temp.length;j++){
            System.out.println(temp[j]);
        }
    }
}
