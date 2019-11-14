package OneDayPractice;


//求两个正整数的最大公约数和最小公倍数
//辗转相除法
import java.util.Scanner;

public class test10 {

        public static void main(String args[]){
            Scanner scanner = new Scanner(System.in);
            int m = scanner.nextInt();
            int n = scanner.nextInt();
            int y = m*n;
            if(m>n){
                int t = m;
                m = n;
                n = t;
            }
            int result = m%n;
            while(result != 0){
                m = n;
                n = result;
                result = m%n;
            }
            System.out.println("最大公约数：" + n);     //最大公约数
            System.out.println("最小公倍数："  + y/n);  //最小公倍数
        }


}
