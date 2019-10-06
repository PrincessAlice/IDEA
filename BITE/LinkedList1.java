class Node{
	public int value;
	public Node next=null;
	
    public Node(int value){
		this.value=value;
    }
}

public class LinkedList1{
    public static void display(Node head){					//
		for(Node cur=head;cur!=null;cur=cur.next){
			System.out.printf("(%d)-->",cur.value);
		}
		System.out.println("null");
    }
    
    public static Node pushFront(Node head,int value){		//头插
		Node node=new Node(value);
		node.next=head;
		return newNode;
    }

    public static Node pushBack(Node head,int value){		//尾插
		Node node=new Node(value);
		if(head=null){
			node.next=head;
			return newNode;
		}else{
			Node newLast=new Node(value);
			Node.last=getLast(head);
			last.next=newNode;
			
			return head;
		}
	}
	
	private static Node getLast(Node head){
		Node last=head;
		while(last.next!=null){
			last=last.next;
		}
		return last;
	}


    public static void main(String[] args){
	    Node head=null;//表示head指向的链表是空链表
	    head=pushBack(head,1);
		haed=pushBack(head,2);
		head=pushBack(head,3);
		display(head); 			//
		head=pushFront(head,10);
		head=pushFront(head,20);
		head=pushFront(head,30);
		display(head);
    }
}