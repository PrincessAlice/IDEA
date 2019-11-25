package OneDayPractice.day15;

//另类加法
//请编写一个函数，将两个数字相加。不得使用+或其他算数运算符。
//即使用位运算

import java.util.Scanner;

public class Main1 {
    public static int addAB(int A, int B){
        if(B==0){
            return A;
        }else{
            int sum = A^B;  //只相加不进位
            int jw = (A&B)<<1; //只进位不相加
            return addAB(sum,jw);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        System.out.println(addAB(a,b));
    }
}
