//删除有序链表中的重复结点

class ListNode{
	int val;
	ListNode next;
	
	ListNode(int val){
		this.val=val;
	}
	
}



Node intlength(Node head){

    int count=0;
	Node cur=head;
	while(cur!=null){
		cur=cur.next;    //cur指向下一个结点
	
		count++;
	}

}

Node findMiddle(Node head){
	int size=getlength(head)/2;
	
	Node fast=head;
	Node slow=head;
	while()
}

class Solution{
  public ListNode partition(ListNode pHead,int x;int val){
	ListNode small=null;
	ListNode big=null;
	ListNode smallLast=null;
	ListNode bigLast=null;
	for(Node cur=head;cur!=null;cur=cur.next){
		if(cur.val<x){
			//尾插到small
			if(small==null){
				small=cur;
			}else{
				smallLast.next=cur;
			}
			smallLast=cur;
		}else{
			//尾插到big
			if(big==null){
				big=cur;
			}else{
			    bigLast.next=cur;
			}
			bigLast=cur;
			
		}
	}
	//easily forget:需要保证链表的最后一个结点的 next==null
	if(small==null){
		return big;
	}else{
		smallLast.next=big;
		if(bigLast!=null){
			bigLast.next=small;
		}
		return small;
	}
	
  }
  
    public ListNode deleteDuplication(ListNode pHead){
	
	if(pHead==null){
		return null;
	}
	 
    //如果开始两个结点相等，没有前驱结点
	//法一：插入一个假结点fake，	 
	  listNode prev=new ListNode(0);
	  prev.next=pHead;
	  ListNode fake=prev;
	  ListNode p1=pHead;
	  ListNode p2=pHead.next;
	  
	    while(p2!=null){
		    if(p1.val!=p2.val){
			  prev=p1;
			  p1=p1.next;
			  p2=p2.next;
		    }else{
			  //p2为空 或者p2.val!=p1.val
			while(p2!=null&&p2.val==p1.val){
				p2=p2.next;
			}
			//删除从[p1,p2)的所有结点，需要前驱结点
            prev.next=p2; 
		    p1=p2;
			//p2可能为空
			if(p2!=null){
				p2=p2.next;
			}
		  }
	    }
	    return fake.next;
		
	//法二：直接强行使头结点pHead=p2,删除相同的结点
	listNode prev=null;
    ListNode p1=pHead;
	ListNode p2=pHead.next;
	  
	    while(p2!=null){
		    if(p1.val!=p2.val){
			  prev=p1;
			  p1=p1.next;
			  p2=p2.next;
		    }else{
			  //p2为空 或者p2.val!=p1.val
			    while(p2!=null&&p2.val==p1.val){
				p2=p2.next;
			}
			//删除从[p1,p2)的所有结点，需要前驱结点
            if(prev==null){
				phead=p2;
			}else{
			    prev.next=p2;
            }
			/*if(p2=null){break;}*/
			if(p2!=null){
				p2=p2.next;
			}
		  }
	    }
	    return phead;
		
    }

}