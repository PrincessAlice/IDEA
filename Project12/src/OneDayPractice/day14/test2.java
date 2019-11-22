package OneDayPractice.day14;

import java.util.Scanner;
import java.util.ArrayList;
public class test2 {
    public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            while (sc.hasNext()) {
                ArrayList<Integer> al = new ArrayList<>();
                int[] nums = new int[10];
                for (int i = 0; i < 10; i++) {
                    nums[i] = sc.nextInt();
                }
                for (int i = 1; i < 10; i++) {
                    for (int j = 0; j < nums[i]; j++) {
                        al.add(i);
                    }
                }
                System.out.print(al.get(0));
                for (int i = 0; i < nums[0]; i++) {
                    System.out.print(0);
                }
                for (int i = 1; i < al.size(); i++) {
                    System.out.print(al.get(i));
                }
                System.out.println();
            }
    }
}
