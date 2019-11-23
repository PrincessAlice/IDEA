package OneDayPractice.day9;

//求n!（1<n<1000）的结果末尾0的个数

import java.util.Scanner;
public class test2 {

        public static void main(String[]args){
            Scanner sc = new Scanner(System.in);
            int n = sc.nextInt();
            System.out.println(trailingZeros(n));

        }
        private static int trailingZeros(int n){
            return n==0?0:n/5+trailingZeros(n/5);
        }


}
