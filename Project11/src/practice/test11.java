package practice;

//调整数组元素的位置，使奇数位于偶数之前
public class test11 {
    public static void evenAfterOdd(int[] array,int len){
        if(array == null || len < 1){
            return;
        }

        int pbegin = 0;
        int pend = len-1;
        while(pbegin < pend && (array[pbegin] %2 != 0)){
            pbegin++;
        }

        while (pbegin < pend && (array[pend] % 2 == 0)){
            pend --;
        }

        if(pbegin < pend){
            int tmp = array[pbegin];
            array[pbegin] = array[pend];
            array[pend] = tmp;
        }

    }
    public static void main(String[] args) {

        int[] array={1,2,3,4,5,6,7,8,9,10};
        evenAfterOdd(array,10);
    }

}
