class Node{
	int val;
	Node next;
	
	Node(int val){
		this.val=val;
	}
}

class CNode{
	int val;
	CNode random;
	CNode next;
	
	CNode(int val){
		this.val=val;
	}
}


class Solution{
	//逆置
	Node reverseList(Node head){
		Node result=null;   //结果链表
		Node cur=head;
		while(cur!=null){
			Node next=cur.next;
			
			cur.next=result;
			result=cur;
			
			cur=next;
		}
		return result;
	}
	
	//删除所有元素
	Node removeAll(Node head,int val){
		if(head==null){
			return null;
		}
		
		//如果相等，则删除
		//一开始先跳过第一个结点
		Node prve=head;
		Node cur=head.next;
		
		while(cur!=null){
			if(cur.val==val){
				prve.next=cur.next;
			}else{
				prve=cur;
			}
			
			cur=cur.next;
		}
		
		//处理第一个结点
		if(head.val==val){
			return head.next;
		}
		return head;
	}
	
	//合并
	Node merge(Node head1,Node head2){
		if(head1==null){
			return head2;
		}
		
		if(head2==null){
			return head2;
		}
		
		Node result=null;
		Node last=null;
		
		Node cur1=head1;
		Node cur2=head2;
		
		while(cur1!=null&&cur2!=null){
			if(cur1.val<=cur2.val){
				if(result==null){
					result=cur1;
				}else{
					last.next=cur1;
				}
				last=cur1;
				cur1=cur1.next;
			}else{
				if(result==null){
					result=cur2;
				}else{
					last.next=cur2;
				}
				
				last=cur2;
				cur2=cur2.next;
			}
			
		}
		
		if(cur1==null){
			last.next=cur2;
		}else{
			last.next=cur1;
		}
		
		return result;
	}
	
	//删除有序重复
	Node deleteDuplicate(Node head){
		Node prve=null;
		Node p1=head;
		Node p2=head.next;
		
		while(p2!=null){
			if(p1.val!=p2.val){
				prve=p1;
				p1=p2;
				p2=p2.next;
			}else{
				while(p2!=null&&p2.val==p1.val){
					p2=p2.next;
				}
				
				if(prve==null){
					head=p2;
				}else{
					prve.next=p2;
				}
				
				p1=p2;
				if(p2!=null){
					p2=p2.next;
				}
			}
		}
		return head;
	}
	
	//复制复杂链表
	CNode copy(CNode head){
		if(head==null){
			return null;
		}
		
		CNode cur=head;
		while(cur!=null){
			CNode node=new CNode(cur.val);
			
			node.next=cur.next;
			cur.next=node;
			
			cur=node.next;
		}
		cur=head;
		while(cur!=null){
			if(cur.random!=null){
				cur.next.random=cur.random.next;
			}
			
			cur=cur.next.next;
		}
		CNode newHead=head.next;
		cur=head;
		
		while(cur!=null){
			CNode node=cur.next;
			
			cur.next=node.next;
			if(node.next!=null){
				node.next=node.next.next;
			}
			cur=cur.next;
		}
		return newHead;
	}
	
	
}

public class Course0616{
	static void testReversrList(){
		//1.构建一个链表
		//2.调用逆置方法
		//3.打印
		
		Node n1= new Node(1);
		Node n2= new Node(3);
		Node n3= new Node(6);
		Node n4= new Node(9);
		Node n5= new Node(2);
		Node n6= new Node(5);
		Node n7= new Node(8);
		
		n1.next=n2;
		n2.next=n3;
		n3.next=n4;
		n4.next=n5;
		n5.next=n6;
		n6.next=n7;
		n7.next=null;
		
		Node result=new Solution().reverseList(n1);
		
		for(Node cur=result;cur!=null;cur=cur.next){
			System.out.printf("%d-->",cur.val);
		}
		System.out.println();
		
		
		result=new Solution().reverseList(null);
		
		for(Node cur=result;cur!=null;cur=cur.next){
			System.out.printf("%d-->",cur.val);
		}
		System.out.println();
	}
	
	static void testCopy(){
		CNode n1= new CNode(1);
		CNode n2= new CNode(2);
		CNode n3= new CNode(3);
		CNode n4= new CNode(4);
		
		n1.next=n2;
		n2.next=n3;
		n3.next=n4;
		n1.random=n2;
		n2.random=n1;
		n3.random=n3;
		
		CNode result= new Solution().copy(n1);
		for(CNode cur=n1;cur!=null;cur=cur.next){
			System.out.printf("CNode(%s,%d,%s) --> %n",cur,cur.val,cur.random);
		}
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		
		for(CNode cur=result;cur!=null;cur=cur.next){
			System.out.printf("CNode(%s,%d,%s) --> %n",cur,cur.val,cur.random);
		}
		System.out.println();
	}
	
	public static void main(String[] args){
		testReversrList();
		
		testCopy();
		
	}
}