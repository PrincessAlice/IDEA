package OneDayPractice;

public class test6 {
    public static int ArrayLenHalfNum(int[] arr){
        if(arr == null||arr.length < 0){
            return 0;
        }
        int mid = arr.length>>1;
        int start = 0;
        int end = arr.length-1;
        int index = Partion(arr,start,end);
        while(index != mid){
            if(index > mid){
                end = index -1;
                index = Partion(arr,start,end);
            }else{
                start = index +1;
                index = Partion(arr,start,end);
            }
        }
        int result = arr[mid];
        if(!checkIsMoreThanHalf(arr,result)){
            result = 0;
        }
        return result;
    }


    private static boolean checkIsMoreThanHalf(int[] arr, int num) {
        int count = 0;
        for(int i = 0;i < arr.length;i++){
            if(arr[i] == num){
                count++;
            }
        }
        if(count*2 <= arr.length){
            return  false;
        }
        return true;
    }

    private static int Partion(int[] arr, int left, int right) {
        if(arr == null){
            return -1;
        }

        int tmp = arr[left];
        while(left < right){
            while(left < right && arr[right] >= tmp){
                right--;
            }

            if(left >= right){
                break;
            }else{
                arr[left] = arr[right];
            }

            while(left < right && arr[left] <= tmp){
                left++;
            }
            if(left >= right){
                break;
            }else{
                arr[right] = arr[left];
            }
        }
        arr[left] = tmp;
        return  left;
    }

    public static void main(String[] args) {
        int[] arr ={1,2,3,2,2,2,5,4,2};
        System.out.println(ArrayLenHalfNum(arr));
    }
}
