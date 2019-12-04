package OneDayPractice.day24;

//小易的升级之路
//思路：1.循环输入，怪兽数量，小易的初始化技能值
//2.每一组开始，输入怪兽的防御值，进行PK
//3.PK结果：如果怪兽的防御值<=小易的技能值，小易的技能值加怪兽防御值；
//          如果怪兽的防御值>小易的技能值，小易的技能值加怪兽防御值和小易技能值的最大公约数

import java.util.Scanner;

public class test1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = 0;
        int ability = 0;
        while(scanner.hasNext()){
            num = scanner.nextInt();
            ability = scanner.nextInt();
            for(int i = 0;i<num;++i){
                int monster = scanner.nextInt();
                if(monster <= ability){
                    ability += monster;
                }else {
                    ability += GCD(ability,monster);
                }
            }
            System.out.println(ability);
        }
        scanner.close();
    }

    /*
    * 辗转相除法（欧几里得算法），是非常高效的求最大公约数（GCD）的算法
    * 递推公式：GCD（a,b）==GCD(b,a%b),当a%b==0时，b即为所求的最大公约数
    * */
    public static int GCD(int a,int b){
        int tmp;
        while(b>0){
            tmp = b;
            b = a%b;
            a = tmp;
        }
        return a;
    }
}
