package practice;

//定义一个二维数组：每一行从左到右递增排序，每一列从上到下递增排序
//输入一个整数，判断数组中是否含有该整数
public class test10 {
    public static void Find_val(int[][]arr,int row,int col,int num){
        if(arr !=null && row >0 && col >0){
            int tmpRow = 0;
            int tmpCol = col -1;
            while(tmpRow < row && col >= 0){
                if(arr[tmpRow][tmpCol] == num){
                    System.out.println( "val:" + arr[tmpRow][tmpCol]+ " row:" + tmpRow + " col:" +tmpCol);
                    break;
                }else if(arr[tmpRow][tmpCol] > num){
                    --tmpCol;
                }else{
                    ++tmpRow;
                }
            }
        }
    }
    public static void main(String[] args) {
        int[][]array = {
                {1,2,8,9},
                {2,4,9,12},
                {4,7,10,13},
                {6,8,11,15}
        };
        Find_val(array,3,3,10);
    }
}
