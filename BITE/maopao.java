public void bubbleSort(int[] array){
for(int end=array.length;end>0;end--){
	boolean  sorted=true;
    for(int i=1;i<end;i++){
		if(array[i-1]>array[i]){
			Swap(array,i-1,i);
			sorted=false;
			}
	}
			if(sorted==true){
				break;
			}
	}
}

//返回value所在下标 二分法
public static int binarySearch(int[] arry,int key){
	int left=0;
	int right=array.length-1;
	//橙色取件部分表示[left,right]
	while(left<=right){
		int mid=left+(right-left)/2;
		if(array[mid]<value)
			left=mid+1;
		else if(array[mid]>value)
			right=mid-1;
		else
			return mid;
	}
	return -1;
}

