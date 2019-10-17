import javafx.scene.chart.PieChart;

import javax.xml.crypto.Data;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

//学生表
public class ScannerDemo {
    private interface Where{
        boolean test(Integer i);
    }
    private static class C implements Where{
        @Override
        public boolean test(Integer i){
            return i % 2 == 0;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 0 ;i<10;i++){
            list.add(i);
        }
        ArrayList<Integer> oushu = new ArrayList<>();
        Where where = new C();
        for(int v :list){
            if(where.test(v)){
                oushu.add(v);
            }
        }
        /*
        while(true){
            Date data = new Date();
            SimpleDateFormat fmt = new SimpleDateFormat("Y-M-d HH:mm:ss");
            System.out.println(fmt.format(data));
            Thread.sleep(1000);
        }
        */
        /*Scanner scanner = new Scanner(System.in);

        System.out.println("请输入一个数字：");
        int n = scanner.nextInt();
        scanner.nextLine();
        System.out.printf("你输入的数字是：|%d|%n",n);

        System.out.println("请输入一句话：");
        String s = scanner.nextLine();
        System.out.println("你输入的一句话是：");
        */
    }
}
