package Classes;

import action.Action;

import java.util.List;
import java.util.Scanner;

public  abstract class User {
    private String id;
    private String name;

    public User(String id,String name){
        this.id=id;
        this.name = name;
    }
    //登陆
    private static User currentUser = null;
    public static User login() throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入角色：");
        String role = scanner.nextLine();
        System.out.println("请输入用户ID：");
        String id = scanner.nextLine();
        System.out.println("请输入用户姓名：");
        String name = scanner.nextLine();
       // User user;
        if(role.equals("老师")){
            currentUser = new Teacher(id,name);
        }else if(role.equals("学生")){
            currentUser = new Student(id,name);
        }else{
            throw new Exception("错误角色!");
        }
        return  currentUser;
    }

    public static User getCurrentUser(){
        return currentUser;
    }
    public abstract void menu();

    public abstract boolean input();

    //功能2：查阅图书
    private void queryBooks(){
        List<Book> bookList = Action.queryBooks();
        for(Book book:bookList){
            //《书名》
            System.out.printf("《%s》by %s 价格：%.2f 存量：%d 借阅次数：%d%n",
                    book.getTitle(),book.getAuthor(),book.getPrice(),
                    book.getCurrentCount(),book.getBorrowedCount());
        }
        System.out.println("共查询到"+ bookList.size()+"本书");
    }

    public String getId(){
        return id;
    }

    public String getName(){
        return name;
    }
}
