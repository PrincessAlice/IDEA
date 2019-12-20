package OneDayPractice.day18;

//DNA序列
//输入描述:输入一个string型基因序列，和int型子串的长度
//输出描述:找出GC比例最高的子串,如果有多个输出第一个的子串
import java.util.Scanner;
public class test3 {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            while(sc.hasNext()){
                String dnaseq = sc.nextLine();
                int n = sc.nextInt();
                String need = "";
                double gcratio = 0;
                for(int i=0; i<=dnaseq.length()-n; i++) {
                    String temp = dnaseq.substring(i, i+n);
                    int cg = 0;
                    for(int j=0; j<n; j++) {
                        if(temp.charAt(j)=='G' || temp.charAt(j)=='C') {
                            cg++;
                        }
                    }
                    if(cg*1.0/n>gcratio) {
                        gcratio = cg*1.0/n;
                        need = temp;
                    }
                }
                System.out.println(need);
            }
        }

}
