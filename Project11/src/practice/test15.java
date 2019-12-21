package practice;

//输入一个整形数组，数组有负数和正数。输出子数组中的和的最大值
public class test15 {
    public static int maxArry(int len){

        int[] arr = {1,-2,3,10,-4,7,2,-5};

        if(arr == null || len <1){
            return -1;
        }

        int maxnum = 0x80000000;
        int sum;
        for(int i = 0;i<len;i++){
            sum = 0;
            for(int j = i;j < len;j++){
                sum = sum + arr[j];
                if(sum > maxnum){
                    maxnum = sum;
                }
            }
        }
        return maxnum;
    }

    public static void main(String[] args) {
        int[] arr = {1,-2,3,10,-4,7,2,-5};
        System.out.println(maxArry(8));
    }
}
