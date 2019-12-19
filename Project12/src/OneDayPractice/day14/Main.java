package OneDayPractice.day14;
/*组个最小数
 *给定数字0-9各若干个。
 *你可以以任意顺序排列这些数字，但必须全部使用。
 * 目标是使得最后得到的数尽可能小（注意0不能做首位）。
 */

import java.util.*;
public class Main {
    public static void main(String []args){
            Scanner scanner = new Scanner(System.in);
            int num[]=new int[10];
            for(int i=0;i<10;i++){
                num[i]=scanner.nextInt();
            }

            for(int i=1;i<10;i++){
                if(num[i]!=0){
                    System.out.print(i);
                    num[i]--;
                    break;
                }
            }
            while(num[0]!=0){
                System.out.print(0);
                num[0]--;
            }
            for(int i=1;i<10;i++){
                while(num[i]!=0){
                    System.out.print(i);
                    num[i]--;
                }
            }
    }
}
