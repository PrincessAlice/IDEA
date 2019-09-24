/*class Node{
    public int val;
    public Node next = null;
    public Node(int val){
        this.val = val;
    }

    @Override
    public String toString() {
        return  String.format("Node(%d)",val);
    }
    //public String toString(){return "Node{" + "val=" + val + '}';}
}
*/
public class Practice2 {
    //合并有序链表
    private static Node Merge(Node head1,Node head2){
        if(head1 == null){
            return head2;
        }

        if(head2 == null){
            return head1;
        }

        //1.分别遍历两个链表，取值比较小的结点，尾插到新链表
        //2.大小比较结束后，把剩余的链表连接到新链表的后面
        Node cur1 = head1;
        Node cur2 = head2;
        Node rhead = null;
        Node rlast = null;
        while(cur1 != null && cur2 != null){
           if(cur1.val <= cur2.val){
               //把cur1尾插到新链表
               //如果新链表总没有结点，更新新链表的第一个结点
               //否则找到新链表的最后一个结点，让rlast.next=要插入的节点
               if(rhead == null){
                   rhead = cur1;
               }else{
                   rlast.next = cur1;
               }
               rlast = cur1;   //更新链表的最后一个结点
               cur1 = cur1.next;  //让cur1指向原来链表的下一个结点
           } else {
               //把cur2尾插到新链表
               if (rhead == null) {
                   rhead = cur2;
               } else {
                   rlast.next = cur2;
               }
               rlast = cur2;
               cur2 = cur2.next;
           }
        }
        if(cur1!=null){
            rlast.next = cur1;
        }else{
            rlast.next = cur2;
        }
        return rhead;
    }

    private static Node creatOrderList1(){
        Node n1 = new Node(1);
        Node n2 = new Node(1);
        Node n3 = new Node(3);
        Node n4 = new Node(3);
        Node n5 = new Node(5);
        Node n6 = new Node(6);
        Node n7 = new Node(9);
        n1.next=n2;n2.next=n3;n3.next=n4;n4.next=n5;n5.next=n6;n6.next=n7;
        return n1;
    }

    private static Node creatOrderList2() {
        Node n1 = new Node(2);
        Node n2 = new Node(4);
        Node n3 = new Node(8);
        Node n4 = new Node(10);
        n1.next = n2;n2.next = n3;n3.next = n4;
        return n1;
    }

    public static void main(String[] args) {
        Node n1 = creatOrderList1();
        Node n2 = creatOrderList2();
        Node rhead = Merge(n1,n2);
        for(Node c = rhead;c!=null;c=c.next){
            System.out.println(c);
            //System.out.println(c.toString());
        }
    }
}
