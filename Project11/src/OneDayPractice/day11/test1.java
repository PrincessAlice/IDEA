package OneDayPractice.day11;


//个位数统计
//统计每种不同的个位数字出现的次数并升序输出

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class test1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String n = scanner.next();
        char[] chars = n.toCharArray();

        //有10个i表示0-9，每个i的值表示数字的个数
        List<Integer> list = new ArrayList<>();
        for(int i = 0;i < 10;i++){
            list.add(0);
        }

        for(int i = 0;i < chars.length;i++){
            //遇到一个数字就把值+1
            list.set(chars[i]-'0',list.get(chars[i]-'0')+1);
        }

        for(int i = 0;i <list.size();i++){
            if(list.get(i) >0){
                System.out.println(i + ":" + list.get(i));
            }
        }
    }
}
