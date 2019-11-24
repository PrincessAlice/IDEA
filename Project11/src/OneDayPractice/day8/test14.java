package OneDayPractice.day8;



import java.util.Arrays;
import java.util.Scanner;

//找出N个数中的最小K个
public class test14 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] string = scanner.nextLine().split(" ");
        int[] array = new int[string.length-1];
        for(int i = 0;i<string.length-1;i++){
            array[i] = Integer.parseInt(string[i]);
        }
        Arrays.sort(array);
        for(int i = 0;i<Integer.parseInt((string[string.length-1]));i++){
            System.out.println(array[i]);
            if(i != Integer.parseInt(string[string.length-1])-1){
                System.out.print(" ");
            }
        }
    }
}
