import java.

public class ArrayList{
	private int size=0;
	private int[] array;
	
    public ArrayList(int[] array){
		this.array=new int[array.length];
		
		for(int i=0;i<array.length;i++){
			this.array[i]=array[i];
		}
		//记得更新 size
	    size=array.length;
    }
	
    public void insert(int insert,int element){
	    if(index<0||index>size){
		System.out.println("index 取值范围是[0,%d]%n,size");
		return;
	    }
	//插入过程，要将[index,size-1]数据往后搬移一格，倒着遍历
	    for(int i=size;i>index;i--){
		    array[i+1]=array[i];
	    }
		
		array[index]=element;
		size++;
    }
    
	public void erase(int index){
		if(index<0||index>=size){
			System.out.printf("index 取值范围是[0,%d]%n,size-1");
			return;
		}
		
		for(int i=index+1;i<=size-1;i++){
			array[i-1]=array[i];
		}
		size--;
		//可选
		array[size]=0;
    }
	
	private void ensureCapacity(){
	    if(size<array.length){
		return;
	}
	//否则扩容
	//1.申请新空间，通常大小是1.5倍或2倍
	int oldCapacity=array.length;
	int newCapacity=oldCapacity+oldCapacity/2;
	int[] newarray=int[newCapacity];
	
	for(int i=0;i<size;i++){
		newArray[i]=array[i];
	}
	size++;
	}

    
	
	
	
	public static void main(String[] args){
		int[] array={1,2,3,4,5};
		ArrayList arrayList=new ArrayList(array);
	    System.out.print
	}
}