package OneDayPractice.day18;

//DNA序列
//输入描述:输入一个string型基因序列，和int型子串的长度
//输出描述:找出GC比例最高的子串,如果有多个输出第一个的子串

import java.util.Scanner;

public class test2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
            String str = scanner.next();
            int n = scanner.nextInt();
            int max = 0;
            int maxBeginIndex = 0;
            for(int i = 0;i < str.length()-n;i++){
                int count = 0;
                for( int j = i;j<i+n;j++){
                    if(str.charAt(j) =='G'|| str.charAt(j) =='C'){
                        count++;
                    }
                }
                if(count > max) {
                    maxBeginIndex = i;
                    max = count;
                }
            }
            System.out.println(str.substring(maxBeginIndex,maxBeginIndex+n));
        }
    }
}
