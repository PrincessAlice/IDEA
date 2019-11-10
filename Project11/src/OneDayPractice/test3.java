package OneDayPractice;

//给定一个字符串A和它的长度n，判断是否为一个合法的括号串。
//判断括号是否匹配，即是否成对出现
import java.util.*;

public class test3 {
    public static  boolean chkParenthesis(String A, int n) {
        char[] arrC = A.toCharArray();
        int num = 0;
        int i = 0;
        while(i < arrC.length && num >= 0){
            if(arrC[i] == '('){
                num++;
            }else if(arrC[i] == ')'){
                num--;
            }
            i++;
        }
        if(i < arrC.length || num != 0){
            return false;
        }

        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str1 = scanner.nextLine();
        Integer n = scanner.nextInt();
        System.out.println(chkParenthesis(str1,n));

    }
}
