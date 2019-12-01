package OneDayPractice.day19;

import java.util.Arrays;
import java.util.Scanner;

//子串相等
//现有一个小写英文字母组成的字符串s和一个包含较短小写英文字符串的数组p
// 请设计一个高效算法，对于p中的每一个较短字符串，判断其是否为s的子串
public class test1 {
    public boolean[] chkSubStr(String[]p,int n,String s){
        boolean[] str = new boolean[n];
        for(int i =0;i<n;i++){
            str[i] = s.contains(p[i]);
        }
        return str;
    }
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String[] p = {"ABCDE"};
        int n = scanner.nextInt();
        String s = scanner.nextLine();

        System.out.println(Arrays.toString(p).contains(s));
    }
}
