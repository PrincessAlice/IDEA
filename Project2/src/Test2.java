class Node{
    int val;
    Node next = null;
    Node (int val){
        this.val = val;
    }

    @Override
    public String toString() {
        return "Node{" + "val=" + val +'}';
    }
}

public class Test2 {
    private static Node compersion(Node head,int x){
        Node cur = head;
        Node small = null;
        Node big = null;
        Node sLast = null;
        Node bLast = null;
        while(cur!=null){
            if(cur.val < x){
                if(small == null){
                    small = cur;
                }else{
                    sLast.next = cur;
                }
                sLast = cur;
            }else{
                if(big == null){
                    big = cur;
                }else{
                    bLast.next = cur;
                }
                bLast = cur;
            }
            cur = cur.next;
        }

        if(sLast == null){
            return big;
        }else{
            sLast.next = big;
        }

        if(bLast == null){
            return small;
        }else{
            bLast.next = null;
        }

        return small;
    }

    private static Node createList(){
        Node n1 = new Node(2);
        Node n2 = new Node(5);
        Node n3 = new Node(2);
        Node n4 = new Node(8);
        Node n5 = new Node(6);
        Node n6 = new Node(7);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;
        return n1;

    }

    public static void main(String[] args) {
        Node cur = createList();
        Node rhead = compersion(cur,6);
        for(Node c =rhead;c!=null;c=c.next){
            System.out.println(c);
        }
    }
}
