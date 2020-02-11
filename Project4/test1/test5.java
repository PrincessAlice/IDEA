package OneDayPractice;

//神奇口袋 给出N个数凑成40的方法

import java.util.*;

public class test5 {

        public static void main(String args[]){
            Scanner scanner = new Scanner(System.in);
            while(scanner.hasNextInt()){
                int kind = scanner.nextInt();
                int[] arr = new int[kind];
                for(int i =0;i <kind;i++){
                    arr[i] = scanner.nextInt();

                }
                System.out.println(kinds(arr,kind,40,0));
            }
        }

        public static int kinds(int[] arr,int n,int k,int index){

            if(k==0){
                return 1;
            }

            if(n==0){
                return 0;
            }else{
                return kinds(arr,n-1,k-arr[index],index+1) + kinds(arr,n-1,k,index+1);
            }
        }

}
