package OneDayPractice.day19;
//KMP算法

import java.util.*;

public class SubStr {

        public boolean[] chkSubStr(String[] p, int n, String s) {
            boolean[] result=new boolean[n];
            for(int i=0;i<n;i++){
                if(strIndexOf(s, p[i])>=0){
                    result[i]=true;
                }
            }
            return result;
        }
        private int[] getNext(String p){
            int n=p.length();
            int[] next=new int[n];
            next[0]=-1;
            int i=-1;
            int j=0;
            while(j<n-1){
                if(i==-1||p.charAt(i)==p.charAt(j)){
                    next[j+1]=i+1;
                    i++;
                    j++;
                }else{
                    i=next[i];
                }
            }
            return next;
        }
        private int strIndexOf(String s,String p){
            int m=s.length();
            int n=p.length();
            int[] next=getNext(p);
            int i=0;
            int j=0;
            while(i<m){
                if(j==-1||s.charAt(i)==p.charAt(j)){
                    i++;
                    j++;
                    if(j==n){
                        return i-n;
                    }
                }else{
                    j=next[j];
                }
            }
            return -1;
        }

}
