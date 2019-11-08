package practice;

//编写一个函数，输入是一个无符号整数，返回其二进制表达式中数字位数为 ‘1’ 的个数（也被称为汉明重量）。

public class test18 {
     public static int hammingWeight(int n) {
            int count = 0;
            while(n!=0){
                n=(n-1)&n;  //与运算 将最后一位1置0（取反），计数
                count++;
            }
            return count;
     }

    public static void main(String[] args) {
        System.out.println(hammingWeight(00000000000000000000000000001011));
        System.out.println(hammingWeight(00000000000000000000000010000000));
        System.out.println(hammingWeight(00000000000000000000000010000111));
        System.out.println(hammingWeight(00000000000000000000010011001010));
    }
}
