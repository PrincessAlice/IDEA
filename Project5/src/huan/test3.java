package huan;

public class test3 {
    public static void mergeSort(int[] array){
        mergeSortInternal2(array,0,array.length);
    }

    private static void mergeSortInternal2(int[]array,int low,int high){
        if(low + 1 >= high){
            return;
        }
        int mid = (low + high)/2;       //分成两个区间
        mergeSortInternal2(array,low,mid);
        mergeSortInternal2(array,mid,high);
        merge(array,low,mid,high);          //合并两个有序数组区间
    }
    private static void merge(int[]array,int low,int mid,int high){
        int length = high -low;
        int[] extra = new int[length];
        int ileft = low;        //下标，进行遍历
        int iright = mid;
        int iextra = 0;
        while(ileft < mid && iright < high){
            if(array[ileft] <= array[iright]){
                extra[iextra++] = array[ileft++];       //将数组放进extra数组
            }else{
                extra[iextra++] = array[iright++];
            }
        }
        while(ileft <= mid){
            extra[iextra++]=array[iright++];
        }
        while(iright <= high){
            extra[iextra++] = array[ileft++];
        }

        for(int i=0;i< length;i++){
            array[low+i]= extra[i];
        }
    }


}
