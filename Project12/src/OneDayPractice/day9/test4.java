package OneDayPractice.day9;

//数字颠倒
import java.util.*;
public class test4 {

        public static void main(String[] args){
            Scanner scan = new Scanner(System.in);
            String str = scan.nextLine();
            StringBuffer sb = new StringBuffer(str);
            sb.reverse();
            System.out.println(sb.toString());
        }


}
