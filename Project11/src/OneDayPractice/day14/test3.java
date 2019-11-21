package OneDayPractice.day14;

import java.util.Scanner;
public class test3 {
        public static void main(String[] args) {
            Scanner sc=new Scanner(System.in);
            while(sc.hasNext()){
                int a=sc.nextInt();
                String res="";
                int begin=0;//奇数的起始值
                if(a%2==1){//中位数为奇数时
                    begin=a*a-2*(a/2);
                }else{//中位数为偶数时
                    begin=a*a-2*(a/2)+1;
                }
                res+=begin;
                for(int i=1;i<a;i++)
                    res+="+"+(begin+2*i);
                System.out.println(res);
            }
        }

}
