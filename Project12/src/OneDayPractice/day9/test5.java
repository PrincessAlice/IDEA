package OneDayPractice.day9;

//数字颠倒
import java.util.*;
public class test5 {
        public static void main(String []args){
            Scanner sc = new Scanner(System.in);
            int num = sc.nextInt();
            int i=0;
            String res="";

            while(num!=0){
                int t1=num%10;
                int t2=num/10;
                res=res+String.valueOf(t1);
                i++;
                num=t2;
            }
            System.out.println(res);
        }

}
