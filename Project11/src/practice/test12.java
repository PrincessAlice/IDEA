package practice;

//求十进制数在内存中二进制数中1 的个数
public class test12 {
    public  static int Numnerof1(int n){
        int count = 0;
        while(n != 0){
            ++count;
            n = (n-1)%n;
        }
        return count;
    }

}
