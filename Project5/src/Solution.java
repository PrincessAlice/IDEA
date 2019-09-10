import java.util.Arrays;
import java.util.Random;
import java.util.Stack;

public class Solution {

    //快速排序
    public static void quickSort(int[]array){
        quickSortInternal(array,0,array.length-1);
    }
    //[left,right]
    private static void quickSortInternal(int[] array,int left,int right){
        if(left > right){
            return;
        }
        //1.确定准基数：array[right]作为基准值
        //2.遍历，小的左，大的右
        //int pivotIndex = partition1(array,left,right);
        int[] indices = partition4(array,left,right);
        //3.治：分出的两个小区间：left:[left,pivotIndex-1]   right:[pivotIndex+1,right]
        //quickSortInternal(array,left,pivotIndex -1);
        //quickSortInternal(array,pivotIndex+1,right);
        quickSortInternal(array,left,indices[0]);
        quickSortInternal(array,indices[1]+1,right);
    }

    private static int partition1(int[]array,int left,int right){
        int pivot = array[right];
        int less = left;
        int great = right;
        while (less<great){
            while(less < great && array[less] <= pivot){
                less++;
            }
            while(less<great && array[great] >= pivot){
                great--;
            }
            swap(array,less,great);
        }
        swap(array,right,less);
        return less;
    }
    private static void swap(int[]array,int i,int j){
        int t = array[i];
        array[i] = array[j];
        array[j] = t;
    }

    private static  int partition2(int[] array,int left,int right){
        int indexpivot = array[right];
        int less = left;
        int great = right;
        while(less <great){
            while(less < great && array[less] <= indexpivot){
                less++;
            }
            array[great] = array[less];
            while(less < great && array[great] >= indexpivot){
                great++;
            }
            array[less] = array[great];
        }
        array[less] = indexpivot;
        return less;
    }

    public static int partition3(int[]array,int left,int right){
        int pivot = array[right];
        int less = left;
        //[left,less) < pivot ;  [less,i) >= pivot ;[i,right)?
        for(int i= left;i<right;i++){
            if(array[i] < pivot){
                swap(array,less,i);
                less++;
            }
        }
        swap(array,less,right);
        return less;
    }

    private static  int[] partition4(int[] array,int left,int right){
        int pivot = array[right];
        int less = left;
        int great = right;
        int i = left;
        while(i<great){
            if(array[i] ==pivot){
                i++;
            }else if(array[i] < pivot){
                swap(array,i,less);
                i++;
                less++;
            }else{
                while(i < great && array[great] >pivot){
                    great --;
                }
                swap(array,i,great);
            }
        }
        return new int[]{less,great -1};
    }

    //非递归的快速排序
    public static void quickSortNoR(int[] array){
        Stack<Integer>stack = new Stack<>();
        stack.push(array.length - 1);
        stack.push(0);
        while(!stack.isEmpty()){
            int left = stack.pop();
            int right = stack.pop();
            if(left >= right){
                continue;
            }

            int pivotIndex = partition1(array,left,right);
            //[left,pivotIndex - 1]
            //[pivotIndex +1,right]
            stack.push(right);
            stack.push(pivotIndex + 1);
            stack.push(pivotIndex - 1);
            stack.push(left);
        }
    }

    //归并排序
    public static void mergeSort(int[]array){
        mergeSortInternal(array,0,array.length);
    }
    private static void mergeSortInternal(int[] array,int low,int high){
        if(low +1 >= high){
            return;
        }
        int mid = (low+high)/2;
        //[low,mid]   [mid,high]
        mergeSortInternal(array,low,mid);
        mergeSortInternal(array,mid,high);
        merge(array,low,mid,high);
    }

    private static void merge(int[]array,int low,int mid,int high){
        int length = high - low;
        int[] extra = new int[length];
        //[low,mid]  [mid,high]
        int iLeft = low;
        int iRight = mid;
        int iExtra = 0;

        while(iLeft < mid && iRight < high){
            if(array[iLeft] <= array[iRight]){
                extra[iExtra++] = array[iLeft++];
            }else{
                extra[iExtra++] = array[iRight++];
            }
        }
        while(iLeft < mid){
            extra[iExtra++] = array[iLeft++];
        }
        while(iRight < high){
            extra[iExtra++] = array[iRight++];
        }
        for(int i = 0;i<length;i++){
            array[low+i] = extra[i];
        }
    }
    //非递归的归并排序
    public static void mergeSortNoR(int[] array){
        for(int i=1;i < array.length;i = i*2){
            for(int j = 0;j < array.length;j = j+2*i){
                int low = j;
                int mid = j+i;
                int high = mid+i;
                if(mid >= array.length){
                    continue;
                }
                if(high > array.length){
                    high = array.length;
                }
                merge(array,low,mid,high);
            }
        }
    }

    private static int[] buildRandom(int n){
        Random random = new Random(20190830);
        int[] array = new int[n];
        for(int i=0;i < n;i++){
            array[i] = random.nextInt(n);
        }
        return array;
    }

    public static void main(String[] args) {
        int[]array = buildRandom(10);
        System.out.println(Arrays.toString(array));
        long begin = System.nanoTime();
        quickSortNoR(array);
        //mergeSort(array);
        //mergeSortNoR(array);
        long end = System.nanoTime();	// 纳秒
        System.out.println(end - begin);
        System.out.println(Arrays.toString(array));
    }
}
