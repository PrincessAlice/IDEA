package practice;

public class test2 {
    public static void main(String[] args) {
        int x = 3;
        int y = 4;
        //x++先运算后自增
       // int result = x++ * y;
        //System.out.println(x);
       // System.out.println(result);

        //++x 先自增后运算
        //int result1 = ++x * y;
        //System.out.println(x);
        //System.out.println(result1);
        //三目运算符
        int z = 3>4?x+y:x-y;
        System.out.println(z);
        //关系运算符
        char a ='哈';
        int n = 10;
        System.out.println(a>n);
        //逻辑运算符
        if(1>2 && (10/0 == 0)){
            System.out.println("条件满足");
        }

        if(1<2||10/0 == 0){
            System.out.println("满足");
        }

    }
}
