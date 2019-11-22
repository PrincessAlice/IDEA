package OneDayPractice.day13;

//超长正整数相加
//输入描述:输入两个字符串数字
//输出描述:输出相加后的结果，string型

import java.math.BigInteger;
import java.util.Scanner;

public class test3 {
    public static void main(String[] args) {
            Scanner scan = new Scanner(System.in);
            while(scan.hasNext()) {
                BigInteger a = scan.nextBigInteger();
                BigInteger b = scan.nextBigInteger();
                BigInteger c = a.add(b);
                System.out.println(c);
            }

    }
}
