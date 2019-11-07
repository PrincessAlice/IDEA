package practice;

//判断一个数是否是2的K次方
public class test14 {
    public static boolean isPower(int n){
        if(n < 1){
            return false;
        }
        int i =1;
        while(i <= n){
            if(i == n){
                return true;
            }
            i <<= 1;
        }
        return  false;
    }

    public static boolean isPower1(int n){
        if(n < 1){
            return false;
        }
        int m = n&(n-1);
        return m == 0;
    }

    public static void main(String[] args) {
        System.out.println(isPower(256));
        System.out.println(isPower(36));
        System.out.println(isPower(16));
        System.out.println(isPower1(3));
    }
}
