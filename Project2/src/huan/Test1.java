package huan;
/**
 * creat:20190822
 * */

class Node{
    int val;
    Node next = null;
    Node(int val){
        this.val=val;

    }
    @Override
    public String toString() {
        return "val=" + val;
    }
}

//链表逆置
public class Test1 {
    public static Node reverse(Node head){

        Node result = null;
        Node cur = head;
        while(cur!=null){
            Node next = cur.next;
            cur.next = result;
            result = cur;
            cur = next;
        }
        return result;
    }

    private static Node createdList(){
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        Node n5 = new Node(6);
        Node n6 = new Node(8);
        Node n7 = new Node(10);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;
        n6.next = n7;
        return n1;

    }

    public static void main(String[] args) {
        Node n1=createdList();
        Node result = new Test1().reverse(n1);
        for(Node cur=result;cur!=null;cur=cur.next){
            System.out.println(cur);

        }
    }
}