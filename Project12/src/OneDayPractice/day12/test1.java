package OneDayPractice.day12;

import java.util.Arrays;
import java.util.Scanner;

public class test1 {
    public static String[] getGray(int n) {
        String[] resStrs = null;
        if(n == 1){
            resStrs = new String[]{"0","1"};
        }else{
            String[] strs = getGray(n-1);
            resStrs = new String[2*strs.length];
            for(int i=0; i<strs.length; i++){
                resStrs[i] = "0"+strs[i];
                resStrs[resStrs.length-1-i] = "1"+strs[i];
            }
        }
        return resStrs;
    }

    public static void main(String[] args) {

        System.out.println(Arrays.toString(getGray(1)));
        System.out.println(Arrays.toString(getGray(2)));
        System.out.println(Arrays.toString(getGray(3)));
        System.out.println(Arrays.toString(getGray(4)));


    }

}
