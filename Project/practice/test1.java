package practice;
//观察变量默认值
class Test{
    public int a;
}

public class test1 {
    public static void main(String[] args) {
        int 变量1 = 10;
        int 变量2 = 10;
        int 计算结果1 = 变量1 + 变量2;
        int 计算结果2 = 变量1 * 变量2;
        System.out.println(计算结果1);
        System.out.println(计算结果2);
        System.out.println(变量1 * 2);
        System.out.println("************************************");
        //观察变量默认值
        Test test = new Test();
        System.out.println(test.a);
        System.out.println("**************************************");

        int numA = 10;
        int numB = 4;
        System.out.println(numA/(double)numB);
        System.out.println("********************************");
        //字符转换
        char c = 'A';
        int num = c;
        System.out.println(num);
        System.out.println("********************************");
        //大写字母变小写字母
        char n1 = 'A';
        int n2 = c + 32;    //char+int = int;
        char x = (char)n2; //int转char需要强转
        System.out.println(x);
        //byte 127~-128
        byte a = 127;
        a+=1;  //加1溢出后为-128
        System.out.println(a);
        System.out.println((byte)128);

    }
}
