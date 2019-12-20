package OneDayPractice.day24;

import java.util.Scanner;

/*
* 最高分是多少
* 思路：
* 交互输入：学生数量，老师可操作次数，学生成绩
* 循环执行M次，如果输入Q进行最大分数计算，如果输入U进行分数更新
* */
public class test2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n =0;
        int m =0;
        while (scanner.hasNext()){
            n = scanner.nextInt();
            m = scanner.nextInt();
            int[] stu = new int[n];
            for(int i = 0;i<n;i++){
                stu[i] = scanner.nextInt();
            }
            for (int i = 0;i < m;i++){
                String c = scanner.next();
                int a = scanner.nextInt();
                int b = scanner.nextInt();
                if(c.equals("Q")){
                    int s = Math.min(a,b);
                    int e = Math.max(a,b);
                    int max = stu[s-1];
                    for(int index = s;index<e;index++){
                        max = Math.max(max,stu[index]);
                    }
                    System.out.println(max);
                }
                if (c.equals("U")) {
                    stu[a-1] = b;
                }
            }
        }
    }

}
