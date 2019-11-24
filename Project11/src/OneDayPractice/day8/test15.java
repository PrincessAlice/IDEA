package OneDayPractice.day8;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class test15 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> list = new ArrayList<>();
        while (scanner.hasNext()){
            list.add(scanner.nextInt());
        }

        int k = list.remove(list.size()-1);
        Collections.sort(list);

        for(int i = 1;i < k-1;i++){
            System.out.println(list.get(i)+" ");
        }
        System.out.println(list.get(k-1));
    }
}
