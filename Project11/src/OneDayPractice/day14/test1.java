package OneDayPractice.day14;

/*组个最小数
 *给定数字0-9各若干个。
 *你可以以任意顺序排列这些数字，但必须全部使用。
 * 目标是使得最后得到的数尽可能小（注意0不能做首位）。
 */
import java.util.Scanner;

public class test1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] A = new int[10];
        A[0] = scanner.nextInt();
        A[1] = scanner.nextInt();
        A[2] = scanner.nextInt();
        A[3] = scanner.nextInt();
        A[4] = scanner.nextInt();
        A[5] = scanner.nextInt();
        A[6] = scanner.nextInt();
        A[7] = scanner.nextInt();
        A[8] = scanner.nextInt();
        A[9] = scanner.nextInt();

        int length = A[0]+A[1]+A[2]+A[3]+A[4]+A[5]+A[6]+A[7]+A[8]+A[9];
        String B = "";
        if(A[0] != 0){
            for(int i = 0;i < 9;i++){
                if(A[i]!=0){
                    B = i +"";
                    A[i] = A[i]-1;
                    break;
                }
            }
        }

        for(int i = 0;i < 9;i++){
            while(A[i] != 0){
                B += i +"";
                A[i] = A[i] - 1;
            }
        }

        System.out.println(B);

    }
}
