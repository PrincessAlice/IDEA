package practice;


public class IntDemo {
    public static class Test{
         int a;
    }
    public static void main(String[] args) {
        Test test = new Test();
        System.out.println(test.a);

        byte data = 10;
        System.out.println(data);
        //将int强转为byte类型
        int num =10;
        int num1 = 4;
        byte d = (byte)num;
        System.out.println(d);
        System.out.println(num/num1);
        System.out.println(num/(double)num1);

        double  c = 10.2;
        System.out.println(c*2);

        float b = 1.1F;
        System.out.println(b);
        System.out.println(1.1*1.1);
        String result = "计算结果：" + num +num1+c;
        System.out.println(result);
    }
}
