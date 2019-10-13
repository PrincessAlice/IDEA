package Classes;

import action.Action;
import exceptions.BorrowedOutException;
import exceptions.NoSuchBookException;
import exceptions.YetBorrowedException;

import java.util.Scanner;

public class Student extends User {
    public Student(String id,String name){
        super(id,name);
    }

    @Override
    public void menu(){
        System.out.println("** 同学，请选择： **");
        System.out.println("**  0.退出 **");
        System.out.println("**  1.上架 **");
        System.out.println("**  2.查阅图书 **");
        System.out.println("**  3.查询记录 **");
    }

    @Override
    public boolean input(){
        Scanner scanner = new Scanner(System.in);
        int selected = scanner.nextInt();
        switch (selected){
            case 0: return true;
            case 1:
                System.out.println("请上架"); break;
            case 2:
                System.out.println("请查阅"); break;
            case 3:
                System.out.println("请查询"); break;
        }
        return false;
    }

    private void borrowBook(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入要借阅书籍的ISBN:");
        String ISBN = scanner.nextLine();
        User user = User.getCurrentUser();
        try{
            Book book = Action.borrowBook(user,ISBN);
            System.out.printf("《%s》借阅成功！%n",book.getTitle());
        }catch(NoSuchBookException e){
            System.out.println("错误！没有这本书");
        }catch(BorrowedOutException e){
            System.out.println("错误！这倍速已经被借光了");
        }catch(YetBorrowedException e){
            System.out.println("错误！这本书你已经接过了");
        }
    }
}
