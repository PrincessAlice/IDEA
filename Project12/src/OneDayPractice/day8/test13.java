package OneDayPractice.day8;

import java.util.Arrays;
import java.util.Scanner;
//找出N个数中的最小K个

public class test13 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while(scanner.hasNext()){
            int n = scanner.nextInt();
            int k = scanner.nextInt();
            int[] arr = new int[n];
            for(int i = 0;i < n;i++){
                arr[i] = scanner.nextInt();
            }

            Arrays.sort(arr);
            for (int j = 0;j<k;j++){
                if(j == (k-1)){
                    System.out.println(arr[j]);
                }else{
                    System.out.print(arr[j] +" ");
                }
            }
        }
    }
}
