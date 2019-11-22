package OneDayPractice.day14;

import java.util.Scanner;

public class test5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
            int A = scanner.nextInt();
            String res = "";
            int start = 0;
            if(A%2 == 1){
                start = A*A-2*(A/2);
            }else {
                start = A*A-2*(A/2)+1;
            }
            res += start;
            for(int i = 1;i < A;i++){
                res += "+" + (start + 2*i);
            }
            System.out.println(res);
        }
    }
}
