//链表的逆置
//1.遍历head代表的链表；
//2.把原链表的每个结点头插到一个新链表上.
class Node{
	public int val;
	public Node next=null;
	
	public Node(int val){
		this.val=val;
	}
	
	@Override
	public String toString(){
		return "val=" + val; 
	}
}

public class Practice0815{
	//链表逆置
	public Node reverse(Node head){
		
		Node result=null;
		Node cur=head;
		while(cur!=null){
			Node next=cur.next;
			cur.next=result;
			result=cur;
			cur=next;
		}
		return result;
	}

	
	
	
	//合并有序链表
	//1.分别遍历两个链表，取值较小的结点，尾插到新链表
	//2.把剩余链表连接到新链表后面
	public static Node Mergelist(Node head1,Node head2){
		if(head1==null){
			return head2;
		}
		
		if(head2==null){
			return head1;
		}
		
		Node cur1=head1;
		Node cur2=head2;
		Node rhead=null;	//新链表
		Node rlast=null;	//记录链表的最后一个节点
		
		while(cur1!=null&&cur2!=null){
			if(cur1.val<=cur2.val){
				//将c1尾插到新链表，如果链表没有结点，更新链表的每一个结点
				if(rhead==null){
					rhead=cur1;	
				}else{
					rlast.next=cur1;
				}
				rlast=cur1;
				cur1=cur1.next;
				
			}else{
				if(rhead==null){
					rhead=cur2;
				}else{
					rlast.next=cur2;
				}
				rlast=cur2;
				cur2=cur2.next;
			
			}
		
		}
		//循环比较大小结束之后，如果有剩余连接到新链表
		if(cur1!=null){
			rlast.next=cur1;
		}
		
		if(cur2!=null){
			rlast.next=cur2;
		}
		
		return rhead;
	}
	
	private static Node creatOrderList1(){
		Node n1 = new Node(1);
		Node n2 = new Node(3);
		Node n3 = new Node(3);
		Node n4 = new Node(5);
		Node n5 = new Node(6);
		Node n6 = new Node(9);
		n1.next=n2;n2.next=n3;n3.next=n4;n4.next=n5;n5.next=n6;
		return n1;
	}
	
	
	private static Node creatOrderList2(){
		Node n1 = new Node(2);
		Node n2 = new Node(4);
		Node n3 = new Node(5);
		n1.next=n2;n2.next=n3;
		return n1;
	}
	
	public static void main(String[] args){
		//Node head1=creatOrderList1();
		//Node head2=creatOrderList2();
		//Node rhead=Mergelist(head1,head2);
		
	 	Node n1 = creatOrderList1();   //静态方法
		Node result = new Practice0815().reverse(n1);    //普通方法
		for(Node cur=result;cur!=null;cur=cur.next){
			System.out.println(cur);
			System.out.println(cur.toString());
			
		}
	}
	
}

	





