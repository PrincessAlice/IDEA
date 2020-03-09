/*
*给定一个数x,比x小的放左边，比x大的放右边
 */
class Node{
     int val;
     Node next = null;
     Node(int val){
        this.val = val;
    }

    @Override
    public String toString(){
         return "Node{" + "val=" + val + '}';}

}

public class Review {
    private static Node compared(Node head,int x){
        Node cur = head;
        Node small = null;
        Node smallLast = null;
        Node big = null;
        Node bigLast = null;
        while(cur!=null){
            if(cur.val < x){
                //把cur尾插到small
                if(small==null){
                    small = cur;
                }else{
                    smallLast.next=cur;
                }
                smallLast = cur;
            }else {
                //把cur尾插到big
                if (big == null) {
                    big = cur;
                } else {
                    bigLast.next = cur;
                }
                bigLast = cur;
            }
            cur=cur.next;
        }
        if(smallLast == null){
            return big;
        }else{
            smallLast.next=big;
        }

        if(bigLast == null){
            return small;
        }else{
            bigLast.next=null;
        }

        return small;
    }

    private static Node createList(){
        Node n1 = new Node(1);
        Node n2 = new Node(9);
        Node n3 = new Node(9);
        Node n4 = new Node(6);
        Node n5 = new Node(7);
        Node n6 = new Node(1);
        Node n7 = new Node(1);
        Node n8 = new Node(1);
        n1.next=n2;n2.next=n3;n3.next=n4;n4.next=n5;n5.next=n6;n6.next=n7;n7.next=n8;
        return n1;
    }

    public static void main(String[] args) {
        Node cur = createList();
        Node rhead= compared(cur,6);
        for(Node c =rhead;c!=null;c=c.next){
            System.out.println(c);
        }
    }
}
