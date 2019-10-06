//表示就是图上的小盒子，结点node
class Node{
	public int value;
	public Node next;
	
    public Node(int value){
		this.value=value;
		this.next=null;
	}
	
}

public class LinkedList{
    public static void displayLinkedList(Node head){
		for(Node cur=head;cur!=null;cur=cur.next){
			System.out.printf("(%d)-->",cur.value);
		}
	}	

    public static Node createLinkedList(){
	    Node n1=new Node(1);
		Node n2=new Node(2);
		Node n3=new Node(3);
		Node n4=new Node(4);
		Node n5=new Node(5);
		
		n1.next=n2;
		n2.next=n3;
		n3.next=n4;
		n4.next=n5;
		n5.next=null;	
		
		return n1;
	}
	
	//头插
	public static Node pushFront(Node head,int value){
		//1.申请新结点
		Node newNode=new Node(100);
		//2.更新newNode 的Next
		newNode.next=head;
		//3.更新head
		//head=newNode;  做了没问题，但实际没有产生任何影响，通常不做
		return newNode;
	}
	
	//尾插
    public static Node pushBack(Node head,int value){
		if(head==null){
			//对空链表尾插
			return pushFront(Node,value);
		}else{
			//对非空链表尾插
			//1.申请新结点，并且让next=null
			Node newNode=new Node(value);
			//2.找到当前的最后一个结点
			Node.next=getLast(head);
			//3.让当前的最后一个结点的next=newNode 
			last.next=newNode;
			
			return head;
		}
    }
	
	public static Node getLast(Node head){
	    Node cur=head;
		/*for(;cur.next!=null;cur=cur.next){
	    }*/
		while(cur.next!=null){
			cur=cur.next;
		}
		return cur;
	}
	
	/*
	
	//头删
	public static Node popFront(Node head){
	    if(head==null){
			System.out.println("参数不合法，无法删除空链表的结点")；
		    return null;
		}	
		return head;
	}
	
	//尾删
	public static Node popBack(){
		
		
	}
	*/
	
	public static void main(String[] args){
		Node head=createLinkedList();
		displayLinkedList(head);
		head=pushFront(head,100);
		
	}
}