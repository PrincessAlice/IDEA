package OneDayPractice.day10;

//斐波那契数列：求一个数转化为斐波那契数至少需要多少步
import java.util.Scanner;

public class test4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = 0;
        int a = 0,b = 1,c = 1;
        if(scanner.hasNextInt()){
            n = scanner.nextInt();
        }
        while( c < n){
            a = b;
            b = c;
            c = a+b;
        }
        int rs1 = n-b;
        int rs2 = c-n;
        System.out.println(rs1<rs2?rs1:rs2);
    }

}
