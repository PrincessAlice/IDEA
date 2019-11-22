package OneDayPractice.day10;


//斐波那契数列：求一个数转化为斐波那契数至少需要多少步
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class test1 {
        private static int getMinF(int m){
            List<Integer>list = new ArrayList<Integer>();
            list.add(0);
            list.add(1);
            list.add(1);
            int n = 2;
            while(list.get(n) <= m){
                n++;
                list.add(list.get(n-1)+list.get(n-2));
            }

            if(list.get(n) - m < m - list.get(n-1)){
                return list.get(n) - m;
            }else{
                return m - list.get(n-1);
            }
        }

        public static void main(String[] args){
            Scanner scanner = new Scanner(System.in);
            int m = scanner.nextInt();
            System.out.println(getMinF(m));
        }


}
