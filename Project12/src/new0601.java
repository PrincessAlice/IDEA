//逆置

class Node{
    public int value;
	public Node newList=null;
	
	public Node(int value){
		this.value=null;
	}
}

public class new0601{
	public ListNode reverse(ListNode head){
		
	}
	
	
    public ListNode removeElements(ListNode head,int val){
	   ListNode newList=null;  
	   ListNode cur=head;
	   ListNode result=null;
	   ListNode last=null;
	   
	   while(cur!=null){
		   ListNode next=cur.next;
		   
		   if(cur.val!=val){
			   //把cur尾插到newList
			   if(newList==null){
				   cur.next=newList;
				   newList=cur;
			   }else{
				   ListNode last=newList;
				   while(last.next!=null){
					   last=last.next;
				   }
				   last.next=cur;
				   cur.next=null;
			   }
		   }
			cur=cur.next;
	   }
	   
	   return newList;
    }
	
	//删除
	public ListNode removeElements2(ListNode head,int val){
	   ListNode newList=null;  
	   ListNode cur=head;
	   
	   while(cur!=null){
		   ListNode next=cur.next;
		   
		   if(cur.val!=val){
			   //把cur尾插到newList
			   if(newList==null){   //第一次尾插时，newList空链表
				   cur.next=newList;
				   newList=cur;
			   }else{               //以后尾插时，newList不是空链表
				   last.next=cur;
			   }
			   last=cur;          //负责更新last
		   }
			cur=next;
	   }
	   if(last!=null){       //处理head==null的情况
	       last.next=null;	   //保证了最后一个结点的next==null
	   }
	   return newList;
    }
	
}


public class new0601{
	public static void display(List)
}