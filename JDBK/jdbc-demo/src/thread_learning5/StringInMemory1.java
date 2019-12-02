package thread_learning5;

public class StringInMemory1 {

    static class  Node{
        Node next;
    }

    public static void main(String[] args) {
        Node first = new Node();
        Node second = new Node();
        Node third = new Node();
        first.next = second;
        second = third; // 原本的second 变量执行其他的变量
    }
}
