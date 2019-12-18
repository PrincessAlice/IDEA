package NET_learning4;

public class Test {
    public static void main(String[] args) {
        //目录地址
        System.out.println(Test.class.getClassLoader().getResource("login.html"));
        //对象
        System.out.println(Test.class.getClassLoader().getResourceAsStream("login.html"));
    }
}
