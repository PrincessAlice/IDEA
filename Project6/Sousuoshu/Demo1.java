package Sousuoshu;

public class Demo1 {
    private static void main(String[] args) {
        String a = "900 google.mail.com";
        String[] t = a.split(" ");  //用空格来分割
        System.out.println(t[0]);
        System.out.println(t[1]);
        int n = Integer.valueOf(t[0]);   //将String 类型转成 integer 类型，需要求出字符串出现的个数
        String[] b = t[1].split("\\.");
        System.out.println(b[0]);
        System.out.println(b[1]);
        System.out.println(b[2]);
        String[] c = {"google","com"};
        String d = String.join(".",c);
        System.out.println(d);

    }
}
