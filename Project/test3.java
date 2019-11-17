package OneDayPractice.day9;

//求n!（1<n<1000）的结果末尾0的个数
import java.math.BigInteger;
import java.util.Scanner;
public class test3 {

        public static void main(String []args) {
            Scanner sc = new Scanner(System.in);
            int n=sc.nextInt();
            BigInteger result = new BigInteger("1");
            for(int i=n;i>0;i--){
                BigInteger num=new BigInteger(String.valueOf(i));
                result=result.multiply(num);
            }
            StringBuffer sb=new StringBuffer(String.valueOf(result));
            sb.reverse();
            int count=0;
            while(sb.substring(count,sb.length()).startsWith("0")){
                count++;
            }
            System.out.println(count);
        }

}
