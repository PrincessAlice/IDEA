package OneDayPractice.day16;

//统计同成绩学生人数
/* 输入  3
        80 60 90
        60
        2
        85 66
        0
        5
        60 75 90 55 75
        75
        0

输出：
1
0
2
*/


import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
            int N = scanner.nextInt();
            if(N==0){
                return;
            }
            int [] num = new int[N];
            for (int i = 0;i <  num.length;i++){
                num[i] = scanner.nextInt();
            }
            int TNum = scanner.nextInt();
            int count = 0;
            for(int i = 0;i < num.length;i++){
                if(TNum == num[i]){
                    count++;
                }
            }
            System.out.println(count);
        }

    }
}
