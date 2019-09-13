import java.util.ArrayList;
import  java.util.List;

//给定一个非负数numRows，生成杨辉三角的前n行
public class Solution {
    //法一：按照顺序一个一个数打印
    public List<List<Integer>>generate0(int numRows){
        List<List<Integer>>list;
        list = new ArrayList<>();
        for(int i = 0;i < numRows;i++){
            List<Integer>nums = new ArrayList<>();
            nums.add(1);
            for(int j = 0;j <= i-2;j++){
                List<Integer>preNums = list.get(i-1);
                int p = preNums.get(j);
                int q = preNums.get(j+1);
                int n = p+q;
                nums.add(n);
            }
            if(i!=0){
                nums.add(1);
            }
            list.add(nums);
        }
        return list;
    }

    //法二：先将1打印出来，再按照规律打印其他的
    public List<List<Integer>>generate1(int numRows) {
        List<List<Integer>> list = new ArrayList<>(numRows); //每一个顺序表的元素类型都是另一个顺序表（线性表）的引用
        for (int i = 0; i < numRows; i++) {
            list.add(new ArrayList<>(i + 1));
        }
        list.get(0).add(1);
        list.get(1).add(1);
        list.get(1).add(1);
        for (int i = 2; i < numRows; i++) {
            List<Integer> nums = list.get(i);
            nums.add(1);
            for (int j = 1; j < i; j++) {
                int num = list.get(i - 1).get(j - 1) + list.get(i - 1).get(j);
                nums.add(num);
            }
            nums.add(1);
        }
        return list;
    }

    private List<List<Integer>>generate2(int numRows){
            List<List<Integer>>list=new ArrayList<>(numRows);
        //法三：先都填进去1，再进行修改相应的位置的数
        for(int i = 0;i<numRows;i++){
            list.add(new ArrayList<>(i+1));
            for(int j = 0;j <= i;j++){
                list.get(i).add(1);
               if (i > 1 && j>0 && j<i) {
                  List<Integer> middle = list.get(i);
                   int num = list.get(i-1).get(j-1) + list.get(i - 1).get(j);
                   middle.set(j,num);
               }
            }
        }
        return list;
    }

    private static void printPascalsTriangle(Solution s,int n){
       System.out.println(s.generate0(n));
       System.out.println(s.generate1(n));
       System.out.println(s.generate2(n));
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        printPascalsTriangle(solution,6);
    }
}
