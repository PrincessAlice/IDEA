//复杂链表的复制
/* 1.遍历原链表，复制每个结点，把新结点插入到对应的老结点的后边
   2.遍历每组（老+新结点），进行random的赋值
   3.拆分成新链表和老链表
*/

class Node{
	public int val;
	public Node next;
	public Node random;
	public Node(int val){
		this.val=val;
	}
}

public class new0614{
	public Node copyRandomList(Node head){
		if()
		
		Node cur=head;
		while(cur!=null){
			//复制新结点
			Node node=new node(cur.val);
			//把新结点node插入到对应的老结点cur的后边
		    node.next=cur.next;
			cur.next=node;
		
		    //让cur指向老的下一个结点
			cur=cur.next.next;
			//cur=node.next;     (same)
		}
		
	    cur=head;
		while(cur!=null){
			//cur.random 可能是null
			if(cur.random!=null){
				cur.next.random=cur.random.next;
			}else{
				cur.random=null;
			}
			//让cur指向老的下一个结点
			cur=cur.next.next;
		}
		
		cur=head;
		Node newHead=head.next;
		while(cur!=null){
			//拆分链表，要改变两个next的指向
			Node node=cur.next;
			cur.next=node.next;
			if(node.next!=null){
				node.next=node.next.next;
			}
			
			//让cur指向老的下一个结点
			cur=cur.next;
		}
		
		
		
	}
	
	
	
	
	
	
	
	
}