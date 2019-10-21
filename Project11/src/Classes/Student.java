package Classes;

import Databases.BookShelf;
import Databases.RecordShelf;
import action.Action;
import exceptions.BorrowedOutException;
import exceptions.NoSuchBookException;
import exceptions.NotBorrowedException;
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
        System.out.println("** 4. 查询借阅情况 **");
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

    //借书
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
            System.out.println("错误！这本书已经被借光了");
        }catch(YetBorrowedException e){
            System.out.println("错误！这本书你已经接过了");
        }
    }

    //还书
    private void returnBook(){
        // 用户界面
        // 还书-前提条件
        // 1. 判断有没有这本书
        // 2. 用户借过该书
        // 还书-流程
        // 1. 借阅记录删除
        // 2. 书的存量 + 1
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入要归还书籍的ISBN：");
        String ISBN = scanner.nextLine();
        User user = User.getCurrentUser();
        try{
            BookShelf bookShelf = BookShelf.getInstance();
            Book book = bookShelf.search(ISBN);
            RecordShelf recordShelf = RecordShelf.getInstance();
            recordShelf.remove(user,ISBN);
            book.returnBook();
            System.out.printf("《%s》归还成功！%n",book.getTitle());
        }catch(NoSuchBookException e){
            System.out.println("错误！没有这本书");
        }catch (NotBorrowedException e){
            System.out.println("错误！没有借过这本书");
        }
    }
}
