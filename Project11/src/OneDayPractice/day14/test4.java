package OneDayPractice.day14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class test4 {

        public static void main(String[] args) throws IOException{
            BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
            String s;
            while((s=bf.readLine())!=null){
                long m = Integer.valueOf(s);
                long a = m*m-m+1;
                System.out.print(a);
                for(int i=1; i<m; i++){
                    System.out.print("+"+(a+=2));
                }
                System.out.println();
            }
            bf.close();
        }

}
