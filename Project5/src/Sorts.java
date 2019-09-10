import java.util.Arrays;
import java.util.Random;

public class Sorts {
    //直接插入排序
    // 有序区间 	[0, i]
    // 无序区间		[i + 1, array.length)
    // 待插入的数据是 array[i + 1]
    // 插入过程在有序区间内查找
    public static void insertSort1(int[] array){
        for(int i= 0;i< array.length-1;i++){
            int key = array[i+1];
            int j;
            for(j=i;j>=0;j--){
                if(key >= array[j]){
                 break;
                }
            }
            //j+1 放 key 的位置
            for(int k= i;k>j;k--){
                array[k+1] =array[k];
            }
            array[j+1] = key;
        }
    }
    //插入排序的另一种写法
    //从后往前一直查找，若元素key
    public static void insertSort2(int[] array){
        for(int i= 0;i<array.length-1;i++){
            int key =array[i+1];
            int j ;
            for(j=i;j>=0 && key<array[j];j--){
                array[j+1] =array[j];
            }
            array[j+1] = key;
        }
    }

    //希尔排序(分组插排)
    private static void insertSortWithGap(int[] array,int gap){
        for(int i = 0;i < array.length - gap;i++){
            int key = array[i+gap];
            int j;
            for(j = i; j >= 0 && key < array[j];j -= gap){
                array[j+gap] = array[j];
            }
            array[j + gap] = key;
        }
    }
    public static void shellSort(int[]array){
        int gap = array.length;
        while(true){
            gap = gap/3+1;
            insertSortWithGap(array,gap); //调用insertSortWithGap
            if(gap == 1){
                return;
            }
        }
    }

    //构建有序数组
    private static int[] buildSortedArray(int n){
        int[] array = new int[n];
        for(int i = 0; i < n;i++){
            array[i] = n-i;
        }
        return array;
    }
    //随机数组
    private static int[] buildRandomArray(int n){
        Random random = new Random(20190828);
        int[] array = new int[n];
        for(int i = 0;i<n;i++){
            array[i] = random.nextInt(n);
        }
        return array;
    }
    //构建逆序数组
    private static int[] buildReversedSortedArray(int n){
        int[] array = new int[n];
        for(int i = 0;i < n;i++){
            array[i]= n - i;
        }
        return array;
    }
    //构建相等数组
    private static int[] buildEqualsArray(int n){
        int[] array = new int[n];
        for(int i = 0;i < n;i++){
            array[i]= n;
        }
        return array;
    }

    //直接选择排序
    public static void selectSort(int[] array){
        //每次选最大的数（循环n-1次）
        for(int i=0;i<array.length-1;i++){
            //无序区间[0,array.length-i)
            //有序区间[array.length-i,array.length)
            int max = 0;
            for(int j= 1;j<array.length-i;j++){
                if(array[j] >= array[max]){
                    max = j;
                }
            }
            //交换最大的数和无序区间的最后一个数
            swap(array,max,array.length-i-1);
        }
    }
    //直接选择排序（进阶版）
    public static void selectSortVersion2(int[] array){
        int low = 0;
        int high = array.length -1;
        //无序区间是[low,high]   无序区间长度 <= 1
        while(low <= high){     //当low == high 时无序区间只有一个数
            int min = low;
            int max = low;
            for(int i= low+1;i <= high;i++){   //获取最大值和最小值的下标
                if(array[i] >array[max]){
                    max = i;
                }
                if(array[i] <array[min]){
                    min = i;
                }
            }
            swap(array,min,low);
            if(max == low){  //伴随着交换，最大数和最小数的下标位置会改变,需要再次交换才正确
                max = min;
            }
            swap(array,max,high);
            low++;
            high--;
        }
    }
    private static void swap(int[]array,int i,int j){
        int t = array[i];
        array[i] = array[j];
        array[j] = t;
    }

    //堆排
    public static void heapSort(int[] array){
        createHeap(array,array.length);      //建堆
        for(int i = 0;i < array.length-1;i++){
            //无序[0,array.length -i)
            swap(array,0,array.length-i-1);
            //无序[0,array.length-i-1)
            //无序区间的长度：array.length-i-1
           heapify(array,array.length-i-1,0);       //向下调整
        }
    }
    private static void createHeap(int[]array,int length){
        for(int i = (length-2)/2;i >= 0;i--){
            heapify(array,length,i);
        }
    }
    private static void heapify(int[] array,int length,int index){
        int left = 2*index +1;
        while(left < length){
            int max =left;
            if(left +1 <length && array[left +1] >array[left]){
                max = left +1;
            }
            if(array[index] >= array[max]){
                break;
            }
            swap(array,index,max);
            index = max;
            left = 2*index +1;
        }
    }

    //冒泡排序
    public static void bubbleSort(int[]array){
        for(int i=0;i<array.length-1;i++){
            //无序区间是[0,array.length-i)
            boolean sorted = true;
            for(int j=0;j<array.length -i-1;j++){
                if(array[j] > array[j+1]){
                    swap(array,j,j+1);
                    sorted = false;
                }
            }
            if(sorted){
                break;
            }
        }
    }

    //选择排序（退化版）
    public static void sort(int[] array){
        for (int i=0;i <array.length-1;i++){
            for(int j=0;j<array.length-i;j++){
                if(array[j] > array[array.length-i-1]){
                    swap(array,j,array.length-i-1);
                }
            }
        }
    }

    public static void main(String[] args) {
        //有序 | 无序 |随机值 |完全相等的
        int[] array;
        //构建了一个有序数组，打印原数组的位置，然后记一下时，打印排序的所需时间，打印排序的结果
        //array = buildSortedArray(10);
        //System.out.println(Arrays.toString(array));
        //array = buildReversedSortedArray(100000);
        array = buildRandomArray(10);
        //array = buildEqualsArray(10);
        System.out.println(Arrays.toString(array));
        long begin = System.nanoTime(); //纳秒（打印前计时）
        insertSort1(array);             //进行插入排序
        long end = System.nanoTime();  //纳秒 （打印后计时）
        System.out.println(end -begin);     //打印排序所需时间
        System.out.println(Arrays.toString(array)); //打印排序结果
        heapSort(array);

    }
}
