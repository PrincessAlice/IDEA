package practice;

public class test13 {
    private static int[] sumK(int[]array,int key){
        int low = 0;
        int high = array.length-1;
        int sum = 0;
        int[] tmpArray = new int[2];
        while(low <= high){
            sum = array[low]+array[high];
            if(sum < key){
                low ++;
            }else if(sum > key){
                high --;
            }else{
                tmpArray[0] = low;
                tmpArray[1] = high;
                break;
            }
        }
        return  tmpArray;
    }

    public static void main(String[] args) {
        int[] array ={1,2,3,4,5,7,7,8};
        sumK(array,8);
        System.out.println();

    }
}
