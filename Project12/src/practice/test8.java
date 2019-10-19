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
    }
}
