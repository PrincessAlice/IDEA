package OneDayPractice.day8;

import java.util.Arrays;
import java.util.Scanner;
//找出N个数中的最小K个

public class test12 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
            int n = scanner.nextInt();
            int need = scanner.nextInt();
            int[] array = new int[n];
            for(int i = 0;i<n;i++){
                array[i] = scanner.nextInt();
            }

            Arrays.sort(array);
            for(int i = 0;i<need;i++){
                System.out.println(array[i]+" ");
            }
            System.out.println();
        }
    }
}
