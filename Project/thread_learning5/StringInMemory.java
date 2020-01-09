package thread_learning5;

public class StringInMemory {
    public static void main(String[] args) {
        String s1 = "hello";
        String s2 = "hel";
        String s3 = new String("hello");
        String s4 = "lo";
        String s5 = s2+s4;
        String s6 = "hello";
        System.out.println(s1 == s6);  //相等
        System.out.println(s1 == s3.intern());  //intern 返回变量值  相等
        System.out.println(s1 == s5);  //不相等

        System.out.println("***********************************");

        int i1 = 128;
        int i2 = 128;
        Integer i3 = 128;
        Integer i4 = 128;
        Integer i5 = 10;
        Integer i6 = 10;
        Integer i7 = new Integer(10);
        System.out.println(i1 == i2);   //比较对象的所占大小
        System.out.println(i1 == i3);   //比较值的大小
        System.out.println(i4 == i3);  //超出范围
        System.out.println(i5 == i6); //在int（-128~128）范围内
        System.out.println(i6 == i7); //

    }
}
