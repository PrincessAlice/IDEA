package OneDayPractice.day9;

//求n!（1<n<1000）的结果末尾0的个数
import java.util.*;
public class test1 {

        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            int n = sc.nextInt();
            int res = 0;
            for(int i = n; i >= 5; i--) {
                int tmp = i;
                while(tmp % 5 == 0) {
                    res++;
                    tmp /= 5;
                }
            }
            System.out.println(res);
        }
}
