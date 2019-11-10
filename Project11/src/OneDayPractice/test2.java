package OneDayPractice;

import java.util.Scanner;

public class test2 {
    public static boolean isHuiWen(String str) {
        int i = 0;
        int j = str.length() - 1;
        while (i < j) {
            if (str.charAt(i) != str.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    public static int number(String a, String b) {
        int count = 0;
        int len = a.length();
        for (int i = 0; i <= len; i++) {
            String str = a.substring(0, i) + b + a.substring(i, len);
            if (isHuiWen(str)) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        while (s.hasNext()) {
            String a = s.next();
            String b = s.next();
            System.out.println(number(a, b));
        }
    }

}
