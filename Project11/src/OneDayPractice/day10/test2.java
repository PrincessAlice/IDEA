package OneDayPractice.day10;


import java.util.Scanner;

//机器人走方格I
public class test2 {
    private static int counts(int x,int y){
        if(x==1 || y==1){
            return 1;
        }
        return counts(x,y-1) + counts(x-1,y);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        System.out.println(counts(a,b));
    }

}
