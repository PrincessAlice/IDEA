package OneDayPractice.day10;

import java.util.Scanner;

//机器人走方格I
public class test3 {
    public static int counts(int x,int y){
        if(x<0||y<0){
            return 0;
        }

        if(x==1|| y==1){
            return 1;
        }

        if(x<y){
            int tmp = x;
            x = y;
            y = tmp;
        }
        int sum = 1;
        int division = 1;
        int a = x,b = y;
        while(b>1){
            sum *= a+b-2;
            division *= b-1;
            b--;
        }
        return sum/division;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        System.out.println(counts(n,m));
    }

}
