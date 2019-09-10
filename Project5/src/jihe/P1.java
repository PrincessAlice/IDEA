package jihe;

import java.util.HashMap;
import java.util.Map;

public class P1 {
    private static Map<Integer,Integer> count(int[] numbers){
        //key:数字    value:数字出现的次数
        Map<Integer,Integer> map = new HashMap<>();
        //判断下n在不在map中
        //不在，出现次数为1
        //在，出现次数+1
        for(int n:numbers){
            int c = map.getOrDefault(n,0);
            //判断查找的数字Key是否存在，若存在则返回他出现的次数，若不存在则返回设定值0
            map.put(n,c+1);
            //记录查找的数字Key出现的次数
        }
        return map;
    }

    public static void main(String[] args) {
        int[] numbers = {3,1,2,4,9,2,3,1,5,8,7,2};
        Map<Integer,Integer> map = count(numbers);
        System.out.println(map);

        //for each的写法 等同于创建Map，调用map.entrySet进行遍历
        for(Map.Entry<Integer,Integer>entry:map.entrySet()){
            int number = entry.getKey();
            int cnt = entry.getValue();
            if(cnt == 2){
                System.out.println(number);
            }
        }

    }

}
