import Classes.Book;
import Classes.User;
import action.Action;

import java.util.Scanner;
//图书管理系统

public class Main {
    public static void main(String[] args) throws Exception {
        //输出提示
        //用Scanner 读用户提示
        //id/name/角色
        //生成用户对象
        User currentUser = User.login();
        boolean isQuit;
        do{
            currentUser.menu();
            isQuit = currentUser.input();
        }while(!isQuit);
        //System.out.println("欢迎下次光临!");
    }

}
