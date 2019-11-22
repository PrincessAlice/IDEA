package OneDayPractice.day12;

import java.util.Scanner;

public class test2 {
    public int[] exchangeAB (int[] AB){
        AB[0] = AB[0] +AB[1];
        AB[1] = AB[0] - 2*AB[1];
        AB[0] = (AB[0] + AB[1])/2;
        AB[1] = AB[0] - AB[1];
        return AB;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println();

    }
}
