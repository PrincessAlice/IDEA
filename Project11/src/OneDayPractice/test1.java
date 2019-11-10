package OneDayPractice;

import java.util.Scanner;

//统计字符串A是否为回文，是回文插入字符串B后构成回文的方法有几种。
//思路：1.前后遍历判断字符串A是否为回文；2.寻找插入位置，使得字符串插入字符串A后为回文
public class test1 {
    public static boolean isSame(String s){
        int i = 0;
        int j = s.length()-1;
        while(i < j){
            if(s.charAt(i) != s.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str1 = scanner.nextLine();
        String str2 = scanner.nextLine();
        int count = 0;
        for(int i = 0;i <= str1.length();i++){
            StringBuilder sb = new StringBuilder(str1);
            sb.insert(i,str2);
            if(isSame(sb.toString())){
                count++;
            }
        }
        System.out.println(count);
    }
}
