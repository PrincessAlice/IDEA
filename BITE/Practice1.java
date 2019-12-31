class Node1{
     int val;
     Node1 next = null;
     Node1(int val){
        this.val = val;
    }

    @Override
    public String toString() {
        return  String.format("Node(%d)",val);
    }
    //public String toString(){return "Node{" + "val=" + val + '}';}
}

public class Practice1 {
    //链表逆置
    //遍历head代表的链表；把每一个结点头插到一新链表上
    public Node1 reverse(Node1 head){
        Node1 rhead = null; //新链表的第一个结点，代表新链表
        Node1 cur = head;//让cur指向head当前指向的对象
        while(cur!=null){
            Node1 next = cur.next; //记录cur原来的下一个结点，因为马上要更改cur.next
            cur.next = rhead; //把cur头插到rhead代表的链表上，cur指向的结点的next应该是原来的第一个结点
            rhead = cur;  //cur指向的结点成为新的第一个结点，rhead指向新的第一个结点
            cur = next;   //让cur指向cur原来的下一个结点
        }
        return rhead;
    }

    private static Node1 creatList(){
        Node1 n1 = new Node1(1);
        Node1 n2 = new Node1(2);
        Node1 n3 = new Node1(3);
        Node1 n4 = new Node1(4);
        Node1 n5 = new Node1(5);
        n1.next=n2;n2.next=n3;n3.next=n4;n4.next=n5;
        return n1;
    }

    public static void main(String[] args) {
        Node1 n1 = creatList();  //静态方法
        Node1 rhead = new Practice1().reverse(n1);  //普通方法
        //打印链表
        for(Node1 c = rhead;c!=null;c=c.next){
            System.out.println(c);
        }
    }

}
