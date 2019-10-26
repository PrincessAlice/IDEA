/*
//接口(有继承关系)
interface A {
	void method1 ();
}

interface B {
	void method2 ();
}

//C 里有两个方法method1,method2
interface C extends A,B {}
*/

//迭代器接口
interface Iterator{
	//返回当前迭代器是否还有后续数据
	boolean hasNext();
	
	//1.先返回当前数值  2.让游标后移一步
	int next();
}


//自带abstract
interface List{
	
	/*
	//给出默认方法
	default int getInstanceMaxSize(){
		return MAX_SIZE;
	}
	
	//给出静态方法
	static int getMaxSize(){
		return MAX_SIZE;
	}
	
	//列出的属性，自带public、static、final 限定符
	int MAX_SIZE =100;
	
	*/
	
	//列出的方法，隐式自带public和abstract 限定符
	
	//插入
	void pushFront(int val);
	void pushBack(int val);
	void insert(int index,int val);
	
	/*
	//删除
	void popFront();
	void popBack();
	void erase(int index);
	*/
	
	//返回数据个数
	int size();
	
	/*
	//根据下标访问或修改
	int get(int index);
	void set(int index,int val);
	*/
	
	//依次打印线性表的每个数据
	void display();
	
	//统一的遍历方式
	Iterator iterator();
	
}

interface RandomAccess{
	
}

abstract class AbstractList implements List{
	protected int size;
	
	@Override
	public void pushFront(int val){
		insertInternal(0,val); 
	}
	
	@Override
	public void pushBack(int val){
		insertInternal(size,val);
	}
	
	@Override
	public void insert (int index,int val){
		if(index<0 || index>size){
			System.out.println("下标错误");
			return;
		}
		insertInternal(index,val);
	}
	
	abstract void insertInternal(int index,int val);
	
	@Override
	public int size(){
		return size;
	}
	
}

class ArrayListIterator implements Iterator{
	private ArrayList arrayList;
	private int currentIndex;
	
	ArrayListIterator(ArrayList arrayList){
		this.arrayList=arrayList;
		this.currentIndex=0;
	}
	
	@Override 
	public boolean hasNext(){
		return currentIndex<arrayList.size();
		
	}
	
	@Override 
	public int next(){
		int val=arrayList.array[currentIndex];
		currentIndex++;
		
		return val;
	}
	
}


//继承放在前面，接口放在后面(单继承，多接口)
class ArrayList extends AbstractList implements List , RandomAccess{
	
	public int[] array=new int[100];
	
	//顺序表的其他实现
	@Override
	public Iterator iterator(){
		return new ArrayListIterator(this);
	}
	
	@Override 
	protected void insertInternal(int index,int val){
		//不考虑扩容问题
		for (int i=size;i>index;i--){
			array[i]=array[i-1];
		}
		
		array[index]=val;
		size++;
	}
	
	@Override
	public void display(){
		for(int i=0;i < size;i++){
			System.out.println(array[i]);
		}
	}
}

/*
class LinkedList extends AbstractList {
	//静态类   对象之间没有关系
	//和普通定义的类完全没有区别，除了可以添加访问限定符
	private static class Node{
		int val;
		Node next=null;
		
		Node(int val){
			this.val=val;
		}
	}
}
*/

public class ListByInterface{
	private static void testList(List list){
		list.pushBack(1);
		list.pushBack(2);
		list.pushFront(10);
		list.insert(3,100);
		//list.display();
		//10,1,2,100
	
		Iterator it1=list.iterator();
		Iterator it2=list.iterator();
		
		//10
		System.out.println(it2.next());
		
		while(it1.hasNext()){
			//10,1,2,100
			System.out.println(it1.next());
		}
		
		while(it2.hasNext()){
			//1,2,100
			System.out.println(it2.next());
		}
		
	}
	
	public static void main(String[] args){
		testList(new ArrayList());
		
		//LinkedList.Node node=new LinkedList.Node(18);     Node 必须有访问权限
	}
}

