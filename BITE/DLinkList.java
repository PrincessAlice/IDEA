public DNode{
	int val;
	DNode prev;     //指向前驱结点，如果是第一个结点，则是null
	DNode next;     //指向后继结点，如果是最后一个结点，则是null
}

//双向带头链表
public class DLinkList{
	private DNode head; //指向第一个结点，没有结点时为null
	private DNode last;  //指向最后一个结点，没有结点时为null
	private int size;
	
	public int size(){
		return size;//属性名   上一个size是方法名，方法名和属性名可同名
	}
	
	public void pushFront(int val){
		DNode node=new DNode(val);
		node.next=head;
		if(head!=null){
			head.prev=node;
		}
		head=node;
		if(last==null){
			last=node;
		}
		size++;
	}
	
	public void pushBack(int val){
		if(head==null){
			pushFront(val);
		}else{
			last.next=new DNode(val);
			last.next.prev=last;
			last=last.next;
			size++;
		}
	}
	
	public void popFront( ){
		if(head==null){
			return; //空结点无法删除
		}else{
			head=head.next;
			if(head==null){
				last=null;
			}else{
				head.prve=null;
			}
			szie--;
		}
	}
	
	public void popBack( ){
		if(head==null){
			return;
		}else if(head.next==null){
			popFront();
		}else{
			last=last.prev;
			last.next=null;
			size--;
		}
	}
	
	
	
	
	
}