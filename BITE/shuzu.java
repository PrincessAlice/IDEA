//二分查找
public static int binarySearch(int[] array,int key){
	int left=0;
	int right=array.length;
	//[left,right)区间内还有数
	while(left<right){
		//计算中间位置的下标
		int mid=left+(right-left)/2;
		//比较
		if(key==array[mid]){
            return mid;			
		}else if(key<array[mid]){
			right=mid;
		}else if(key>array[mid]){
			left=mid+1;
		};
	}
	return -1;
}

//冒泡
//交换array数组的i和j下标的位置的数
//因为修改array[i]对应的修改就是引用共同指向的数据
//所以，修改是可以生效的
public static void swap(int[] array,int i,int j){
	int t=array[i];
	array[i]=array[j];
    array[j]=t;
}
//冒泡排序
public static void bubbleSort(int[] array){
	//减治算法
	for(int i=0;i<array.length;i++){
		//需要经过array.length次冒泡
		//所谓的冒泡过程
		//在无序区间内，经过两两比较,把最大的数冒泡到最后
		boolean isSwapped=false;
		//无序      [0,array.length-1)
		//有序      [array.length-1,array.length)
		//进行冒泡过程，遍历整个无序区间
		for(int j=0;j<array.length-i-1;j++){
			if(array[j]>array[j+1]){
				swap(array,j,j+1);
				isSwapped=true;
			}
		}
	
	//如果一次完整的冒泡过程中，一次交换都没有发生
	//表明数组已经有序，所以排序完成
		if(!isSwapped){
			return;
		}
	}
}
public static void testPrint(){
	
}

public static void main(String[] args){

	int[] randomArray=new int[]{9,5,2,0}
	bubbleSort(randomArray); 
	System.out.printf(Array)
}