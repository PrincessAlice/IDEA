import java.util.Scanner;
/**
 * 字母大小写转换
 * toLowerCase 大写转小写
 * toUpperCase 小写转大写
 */


public class day01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String string = scanner.nextLine();
        System.out.println(string.toLowerCase());
        System.out.println(string.toUpperCase());

    }
    public String toLowercase(String str){
        String str1 = str.toLowerCase();
        return str1;
    }

    public String toUpperCase(String str){
        String str2 = str.toUpperCase();
        return str2;
    }
}
