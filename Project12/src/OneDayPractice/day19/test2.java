package OneDayPractice.day19;

import java.util.*;

public class test2 {
    public boolean[] chkSubStr(String[] p, int n, String s) {
            boolean[] flag=new boolean[n];
            for(int i=0; i<n; i++){
                if(s.contains(p[i]))
                    flag[i]=true;
                else
                    flag[i]=false;
            }
            return flag;
    }

    public static void main(String[] args) {
        System.out.println();
    }



}
