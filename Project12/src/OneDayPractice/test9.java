package OneDayPractice;

//神器口袋 装N个数凑成40有多少种方法
import java.util.Scanner;

public class test9 {
    static int[] weight;
    static int N;
    static int count = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNextInt()){
            N = scanner.nextInt();
            weight = new int[N+1];
            for(int i = 1;i <= N;i++){
                weight[i] = scanner.nextInt();
            }

            count(40,N);
            System.out.println(count);
        }
    }

    private static void count(int s, int n) {
        //如果整好装满
        if(s ==  0){
            ++count;
            return;
        }
        //是s<0 或 n < 1则不能完成
        if(s < 0 || s > 0 && n < 1){
            return;
        }
        count(s-weight[n],n-1);
        count(s,n-1);
    }
}
