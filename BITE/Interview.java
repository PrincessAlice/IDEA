class Node{
   public int value;
   public Node next=null;
	
	public Node (int value){
		this.value=null;
	}
}


//逆置链表
public class reverseList{          
    public ListNode reverseList(ListNode head){
	   /*依次遍历原链表的每一个结点，头插一个新的链表中*/
	   ListNode newList=null;   //newList有两层含义，新链表的第一个结点
	   ListNode cur=head;
	   while(cur!=null){
		   //因为一会cur.next会变化，所以提前保存其值
		   ListNode next=cur.next;
		   //头插
		   cur.next=newList;
		   newList=cur;
		   //让cur往后遍历
		   cur=next;
	   }
	   return newList;
    }
	
	public ListNode reverseList2(ListNode head){
	    if(head==null){
			return null;
		}
		ListNode n1=null;
		listNode n2=head;
		listNode n3=head.next;
		
		while(n2!=null){
			n2.next=n1;
			//循环
			n1=n2;
			n2=n3;
			if(n3!=null){
			    n3=n3.next;
			}	
		}
		return n1;
    }
	
	
	
//删除所有的val	
	/*
	1.遍历每个结点，如果结点的值是要删除的值，则删除该结点
	while(cur!=null){
		if(cur.val==val){
			删除cur
		}
		cur=cur.next;
	}
	2.如何删除cur
	对于链表，要删除cur，需要cur的前驱结点，prev代表cur的前驱
	while(cur!=null){
		if()...
		prev=cur;
		cur=cur.next;
	}
	有了prev，如何删除cur； prev.next=cur.next;
	3.画图的过程发现，如果cur.val=val，prev不应该变化
    4.无法处理，当第一个结点就是要删除的val
		1.一开始不管第一个结点，先删后面的，最后在处理第一个
		2.创建一个结点，让结点的.next=原来的第一个
	5.head一开始就是空，怎么办
	*/

//删除所有的val	
	public ListNode removeElements(ListNode head,int val){
		if(head==null){
			return null;
		}
		
		ListNode cur=head.next;
		ListNode prev=head;   //prev 前驱结点
		while(cur!=null){
			if(cur.val==val){
				prev.next=cur.next;
			}else{
				prev=cur;
			}
			cur=cur.next;
		}
		if(head.val==val){
			head=head.next;
		}
		return head;
		
	}
	
	public ListNode removeElements1(ListNode head,int val){
		ListNode fackHead=newListNode(0);
		fackHead.next=head;
		
		
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
	
//删除有序链表中的重复结点
    public Node deleteDuplicated(Node head){
		if(phead==null){
			return null;
		}
		
		//新建假结点
		Node prev=new node(0);
		Node fake=prev;
		prev.next=phead;
		Node p1=phead;
		Node p2=phead.next;
		
		while(p2!=null){
			if(p1.val!=p2.val){
				prev=prev.next;
                p1=p1.next;
                p2=p2.next;				
			}else{
				while(p2!=null&&p1.val=p2.val){
					p2=p2.next;
				}
				prev.next=p2;
				p1=p2;
				
				if(p2!=null){
				    p2=p2.next;
				}
				
				if(p2==null){
					berak;
				}
				
			}
		}
		return fake.next;
		
		
	}
	
	
	
}	


	
public class Interview{	
    public static void main (String[] args){
		ListNode n1=new ListNode(1);
		ListNode n2=new ListNode(2);
		ListNode n3=new ListNode(3);
		ListNode n4=new ListNode(4);
		ListNode n5=new ListNode(5);
		
		
    }
}