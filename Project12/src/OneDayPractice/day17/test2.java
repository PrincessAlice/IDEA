package OneDayPractice.day17;

/**
 * 火车进站
 */
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Set;
import java.util.Stack;
import java.util.TreeSet;

public class test2 {

    public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            while(sc.hasNext()){
                int num = sc.nextInt();
                int[] A = new int[num];
                for(int i=0;i<num;i++){
                    A[i] = sc.nextInt();
                }
                int start = 0;
                ArrayList<int[]> result = new ArrayList<>();
                Permutation(A,start,num,result);
                Set<String> sortResult = new TreeSet<>();
                for(int[] out:result){
                    if(isLegal(A,out,num)){
                        StringBuilder sb = new StringBuilder();
                        for(int i=0;i<num-1;i++){
                            sb.append(out[i]+" ");
                        }
                        sb.append(out[num-1]);
                        sortResult.add(sb.toString());
                    }
                }
                for(String list:sortResult){
                    System.out.println(list);
                }
            }
            sc.close();
    }

    private static boolean isLegal(int[] in,int[] out,int n){
            Stack<Integer> stack = new Stack<>();
            int i=0;
            int j=0;
            while(i<n){
                if(in[i]==out[j]){
                    i++;
                    j++;
                }else{
                    if(stack.isEmpty()){
                        stack.push(in[i]);
                        i++;
                    }else{
                        int top = stack.peek();
                        if(top==out[j]){
                            j++;
                            stack.pop();
                        }else if(i<n){
                            stack.push(in[i]);
                            i++;
                        }
                    }
                }
            }
            while(!stack.isEmpty()&&j<n){
                int top = stack.pop();
                if(top==out[j]){
                    j++;
                }else{
                    return false;
                }
            }
            return true;
    }
        /**
         * 求出所有排序 结果存在result中
         * @param A
         * @param start
         * @param n
         * @param list
         */

        private static void Permutation(int[] A,int start,int n,ArrayList<int[]> result){
            if(start==n){
                return;
            }
            if(start==n-1){//存储最后的数据
                int[] B = A.clone();
                result.add(B);
                return;
            }
            for(int i=start;i<n;i++){
                swap(A,start,i);
                Permutation(A,start+1,n,result);
                swap(A,start,i);
            }
        }

        private static void swap(int[] A,int i,int j){
            int t = A[i];
            A[i]=A[j];
            A[j]=t;
        }

}
