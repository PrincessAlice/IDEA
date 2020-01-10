package class_definition;

//增删查改 双向链表类(very improtance)
public class LinkedList {
     static class Node{
        int val;
        Node next; //指向下一个结点，第一个结点的前驱是null
        Node prev;//指向下一个结点，最后一个结点的后继是null

         Node(int val){
            this.val = val;
         }
     }
    //指向链表的第一个结点，如果链表中没有结点，则==null
    Node first = null;
    //指向链表的最后一个结点，如果链表中没有结点，则==null
    Node last = null;

    //头插
    public void  addFront(int val){
        Node newNode = new Node(val);
        newNode.next = first;
        if(first !=null){
            first.prev = newNode;
        }else{
            last = newNode;
        }
        first = newNode;
    }

    //尾插
    public void addLast(int val){
        Node NewNode = new Node(val);
        NewNode.prev = last;
        if(last!=null){
            last.next = NewNode;
        }
        last = NewNode;
    }

    public int pollFirst1() throws Exception{
        if(first==null){
            throw new Exception("空的链表");
        }
        Node oldFirst = first;
        first = first.next;
        if(first == null){
            last = null;
        }else{
            first.prev=null;
        }
        return oldFirst.val;
    }

    public int pollLast() throws Exception{
        if(last == null) {
            throw new Exception("空的链表");
        }
        Node oldLast = last;
        last = last.next;
        if(last == null){
            first = null;
        }else{
            last.next = null;
        }
        return oldLast.val;
    }

    public void print(){
        System.out.println("打印链表");
        for(Node c = first;c != null;c = c.next){
            System.out.println(c.val);
        }
        System.out.println("================================");
        for(Node c = last;c != null;c = c.prev){
            System.out.println(c.val);
        }
    }

    public static void main(String[] args) throws Exception{
        LinkedList list = new LinkedList();
        list.print();
        list.addFront(1); //空的头插
        list.print();
        list.addFront(2); //非空头插
        list.print();
        list.addLast(3); //非空尾插
        list.print();
        list.pollFirst1();
        list.print();
        list.pollLast();
        list.print();
        list.pollFirst1();
        list.print();
        list.addLast(4);
        list.print();
        list.pollLast();
        list.print();
        /**
         * 1. 空的头插
         * 2. 非空的头插
         * 3. 空的尾插
         * 4. 非空的尾插
         * 5. > 1 结点的头删
         * 6. > 1 结点的尾删
         * 7. == 1 结点的头删
         * 8. == 1 结点的尾删
         * 9. 空链表的头删
         * 10. 空链表的尾删
         *
         * 1. 打印
         * 2. 调试
         */
    }

}
