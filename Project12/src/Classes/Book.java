package Classes;

public class Book {

    private String ISBN;
    private String title;
    private String author;
    private double price;
    //存量
    private int currentCount;
    //总量
    private int totalCount;
    //借阅次数
    private int borrowedCount;

    public Book(String ISBN,String title,String author,double price,int Count){
        this.ISBN = ISBN;
        this.title = title;
        this.author = author;
        this.price = price;
        this.currentCount = Count;
        this.totalCount = Count;
        this.borrowedCount = 0;
    }

    public boolean is(String ISBN){
        return this.ISBN.equals(ISBN);
    }

    public void increaseCount(int count) {
        currentCount = count;   //剩下的书
        totalCount += count;        //总数量
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor(){
        return author;
    }

    public double getPrice(){
        return price;
    }
    public int getCurrentCount() {
        return currentCount;
    }

    public int getBorrowedCount(){
        return borrowedCount;
    }
    public void borrowBook() {
        currentCount--;
        borrowedCount++;
    }
}
