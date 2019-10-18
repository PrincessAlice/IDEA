package practice;

//递归求和
public class test5 {
    public static void main(String[] args) {
        System.out.println(sum(100));
        System.out.println(jiecheng(10));

        //普通循环求10！
        int a =1;
        for(int b = 1; b <= 10;b++){
            a = a*b;
        }
        System.out.println(a);

    }

    public static int sum(int num){
        if(num == 1){
            return 1;
        }else{
            return num+sum(num-1);
        }
    }

    //递归求10!
    public static int jiecheng(int n){
        int m = 0;
        if(n == 1){
            return 1;
        }else{
            m = n * jiecheng(n-1);
            return m;
        }
    }
}
