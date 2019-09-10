package jihe;

import java.util.List;

//字符串
public class P5 {

    private static List<String> addCount(String[] cpdomains){
        for(String cp: cpdomains){   //遍历字符串
            String[] t = cp.split(" ");

        }

    }

    public static  void main(String[] args){
        String s = "900 google.mail.com";
        String[] t = s.split(" ");  //用空格来分割
        System.out.println(t[0]);
        System.out.println(t[1]);
        int n = Integer.valueOf(t[0]);  //将String 类型转成 integer 类型，需要求出字符串出现的个数
        String[] u = t[1].split("\\.");
        System.out.println(u[0]);
        System.out.println(u[1]);
        System.out.println(u[2]);
        String[] v = {"google","com"};
        String w = String.join(".",v);
        System.out.println(w);
    }


}
