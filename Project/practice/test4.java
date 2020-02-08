package practice;

import java.io.IOException;

public class test4 {
    public static void main(String[] args) {
        myPrint(1);
        myPrint(2);
        myPrint(3);
        myPrint(4);

    }
    public static void myPrint(int x){
        if(x == 2){
            return;
        }else {
            System.out.println(x);
        }
    }
    private static String string() throws IOException {
        System.out.println("请输入字符：");
        char x = (char) System.in.read();
        switch (x){
            case 'a':{
                System.out.println("我是公主");
            }
            case 'b':{
                System.out.println("我是猪");
            }
            default:{
                System.out.println("我真的是公主");
            }
        }
        return string();
    }
}
