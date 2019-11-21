package OneDayPractice.day12;

import java.util.Arrays;
import java.util.SortedMap;

public class test4 {
    public static String[] GrayMa(int n){
        String[] string = null;
        if(n==1){
            string = new String[]{"0","1"};
        }else{
            String[] str = GrayMa(n-1);
            string = new String[2*str.length];
            for(int i = 0;i < str.length;i++){
                string[i] = "0"+str[i];
                string[string.length - 1 - i] = "1" + str[i];
            }
        }
        return string;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(GrayMa(1)));
        System.out.println(Arrays.toString(GrayMa(2)));
        System.out.println(Arrays.toString(GrayMa(3)));
        System.out.println(Arrays.toString(GrayMa(4)));
       // System.out.println(Arrays.toString(GrayMa(5)));
    }
}
