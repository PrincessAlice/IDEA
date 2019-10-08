class Node{
public int val;
public Node next=null;

public Node(int val){
this.val=val;
}
}

public class Test{
	public static Node pushFront(Node head,int val){
		Node newnode=new Node(val);
		newnode.next=head;
		return newNode;
   

	}

	public static Node popBack(Node head,int val){
		if(Node==null){
			return null;
		} 
		if(head.next=null){
		return null;
		}
	
		Node c=head;
		while(c.next.next!=null){
		c=c.next;
		}
		c.next=null;
		return head;
	}
}

public class Solution{

	public ListNode FindKthToTail(ListNode head,int k){
	int length=0;
	
	for(ListNode cur=head;cur!=null;cur=cur.next){
		length++;
	}
	if(length<k){
		return null;
	}
	
	int n=length-k;
	ListNode kth=head;
	for(int i=0;i<n;i++){
		kth=kth.next;
	}
	return kth;
	}
	
	public ListNode FindKthToTail2(ListNode head,int k){
		ListNode front=head;
		ListNode back=head;
		
		for(int i=0;i<k;i++){
			if(front=null){
				return null;
			}
			front=front.next;
		}
		while(front!=null){
			front=front.next;
			back=back.next;
		}
		return back;
	}
	
	
	public ListNode middleNode(ListNode head){
	    int length=0;
		for(ListNode cur=head;cur!=null;cur=cur.next){
		    length++;
	    }
		
		int n=length/2;
		return n.next;
	
	}

//合并两个有序单链表	
	public ListNode mergeTwoLists(ListNode11,ListNode12){
		ListNode cur1=11;
		ListNode cur2=12;
		ListNode result=null;
		
		while(cur1!=null&&cur2!=null){
			if(cur1.val<=cur2.val){
				ListNode next=cur1.next;//让循环走起来
				//把cur1尾插到result上
				if(result==null){
					//头插
				cur1.next=result;  //可选的
				result=cur1;
			    }else{
					cur1.next=null;  //
					last.next=cur1;	
				}//保证last永远指向最后一个结点
				last=cur1;
				cur1=next;
			}else{
				ListNode next=cur2.next;//让循环走起来
			    //把cur2尾插到result上
				if(result==null){
					//头插
				cur2.next=result;  //可选的
				result=cur2;
			    }else{
					cur2.next=null;  //
					last.next=cur2;	
				}//保证last永远指向最后一个结点
				last=cur2;
				cur2=next;  //让循环走起来
			}
				
		}
		
		//或者cur1为空 或者cur2为空    current（当前的）
		if(cur1!=null){
			return cur1;
		}else{}
		
		if(cur2!=null){
			
		}else{}
	}
	
}

public static void main(String[] args){
	public static 
}

