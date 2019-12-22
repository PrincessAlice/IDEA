package practice;


//遍历每一个数，遇到1计数
public class test19 {
    public static int hammingWeight1(int n) {
        int bits = 0;
        int m = 1;
        for (int i = 0; i < 32; i++) {
            if ((n & m) != 0) {
                bits++;
            }
            m <<= 1;
        }
        return bits;
    }

    public static void main(String[] args) {
        System.out.println(hammingWeight1(00000000000000000000000000001011));
        System.out.println(hammingWeight1(00000000000000000000000010000000));
        System.out.println(hammingWeight1(00000000000000000000000010000111));
        System.out.println(hammingWeight1(00000000000000000000010011001010));
    }
}
