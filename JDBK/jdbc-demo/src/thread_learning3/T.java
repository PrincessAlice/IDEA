package thread_learning3;

public class T {
    private static int i =0;
    private static int anInt = 0;  //保存在方法区

    public static void run(){}   //保存在方法区

    public static void run2(){}

    public static void main(String[] args) {
        i++;
        //1.获取i的值
        //2.修改i的值
        //3.保存i的值
        Object o = new Object();
    }
}
