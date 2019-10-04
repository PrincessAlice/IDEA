//线性表
abstract class List{
	private int size;    //保存线性表中的数据个数
	
	List(){
		size=0;
	}
	
	public void pushFront(int val){
		insertInternal(0,val);
	}
	
	public void pushBack(int val){
		insertInternal(size,val);
	}
	
	//抽象方法，只给出
    public void insert(int index,int val){
		size++;
    }
	
	public int getSize(){
		return size;
	}
	
}


//顺序表 extends 线性表
class ArrayList extends List{
	private int[] array;
	
	//这里其实可以不写
	ArrayList(){
		super();
		array=new int[10];
	}
	
	//重写
	//注解
	@Override
	public void insert(int index,int val){
		//不考虑扩容
		for(int i=getSize();i>index;i--){
			array[i]=array[i-1];
		}
		
		array[index]=val;
		
		super.insert(index,val);
    }
	
	public void display(){
		for(int i=0;i<getSize();i++){
			System.out.println(array[i]);
		}
	}
	
}


class Node {
	int val;
	Node next=null;
	Node(int val){
		this.val=val;
	}
	
	Node(int val,Node next){
		this.val=val;
		this.next=next;
	}
	
}

//链表
class LinkedList extends List{
	private Node head=null;
	@Override
	public void insert(int index,int val){
		if(index==0){
			pushFront(val);
		}else{
			//找到index位置的前一个结点
			Node prev=head;
			for(int i=0;i<index-1;i++){
				prev=prev.next;
			}
			//在这个结点后面插入val结点
			prev.next=new Node(val,prev.next);
			
			/*上一句的拆分
			Node node=new Node(val);
			node.next=prev.next;
			prev.next=node;
			*/
		}
		incSize();
	}
	
	@Override
	public void display(){
		for(Node cur=head;cur!=null;cur=cur.next){
			System.out.println(cur.val);
		}
	}
	
}

public class Course0623{
	void static testList(List list){
		list.pushBack(1);
		list.pushBack(2);
		list.pushBack(3);
		list.pushFront(10);
		list.pushFront(20);
		list.pushFront(30);
		list.insert(3,100);
		
		list.display();
	}
	
	public static void main(String[] args){
		//List obj=new List();     错误，因为是抽象类
		//ArrayList list=new ArrayList();
		/*LinkedList list = new LinkedList();
		list.pushBack(1);
		list.pushBack(2);
		list.pushBack(3);
		list.pushFront(10);
		list.pushFront(20);
		list.pushFront(30);
		list.insert(3,100);
		
		list.display();
		*/
		
		testList(new ArrayList());
		testList(new LinkedList());
	}
}