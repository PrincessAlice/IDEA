package jihe;


public class RandomList {
    public static  class Node{
        int val;
        Node next;
        Node random;
    }
    public Node copy1(Node head){
        Node p = head;
        while(p != null){
            Node q = new Node();
            q.val = q.val;

            q.next = p.next;
            p.next = q;

            p = q.next;
        }
        p = head;
        while(p != null){

        }

        return null;
    }

}
