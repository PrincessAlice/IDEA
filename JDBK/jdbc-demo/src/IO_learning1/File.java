package IO_learning1;

import java.util.Scanner;

public class File {
    public static void test3(){
        //给定多个测试用例
        //输入:
        //4
        //5 6 7
        //11
        //输出：
        //abc
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
   //         System.out.println("hasNext");
            int i1 = scanner.nextInt();
   //         System.out.println("hasNext");
            int i2 = scanner.nextInt();
    //        System.out.println("hasNext");
            int i3 = scanner.nextInt();
   //         System.out.println("hasNext");
            int i4 = scanner.nextInt();
 //           System.out.println("hasNext");
            int i5 = scanner.nextInt();
            //1.要么对于每个有明确结束标识api的api，需要明确返回这个标识，对于scanner就是换行符
            //2.流关闭
            System.out.println("abc");
        }
    }

    public static void main(String[] args) {
        test3();
    }
}
