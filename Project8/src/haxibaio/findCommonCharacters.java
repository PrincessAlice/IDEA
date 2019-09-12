package haxibaio;

import java.util.*;

public class findCommonCharacters {
    public static  List<String> commonChars(String[] A){
        //第一步：统计每个单词中，每个字母出现次数
        List<Map<Character,Integer>> counts = new ArrayList<>();
        for(String s:A){    //遍历每个单词
            Map<Character,Integer> map = new HashMap<>();  //定义map
            for(char c:s.toCharArray()){            //分割字符
                int n = map.getOrDefault(c,0);
                map.put(c,n+1);
            }
            counts.add(map);
        }
        System.out.println(counts);

        List<String> result = new ArrayList<>();

        //遍历第一个单词中的所有字符，从counts找 第一个Map
        for(char c:counts.get(0).keySet()){        //找出所有的key
            boolean allContains = true;
            for(int i = 1;i < counts.size();i++){
                Map<Character,Integer> map = counts.get(i);
                if(!map.containsKey(c)){
                    allContains = false;
                    break;
                }
            }
            //怎么判断是全包含还是有不包含的？
            if(!allContains){
                continue;
            }
            //找到c在每个单词中出现次数的最小值
            int min = counts.get(0).get(c);
            for(int i = 1;i < counts.size();i++){
                int n = counts.get(0).get(c);
                if( n < min){
                    min = n;
                }
            }
            //c这个字母在美每个单词中都至少出现了min 次
            for(int i = 0;i < min; i++){
                result.add(String.valueOf(c));   //记录结果并将char类型转换成String类型
            }
        }
        return result;
    }

    //法二
    public static List<String> commonChar2(String[] A){
        List<int[]>counts = new ArrayList<>();
        for(String s:A){
            int[] a = new int[26];
            for(char c:s.toCharArray()){
                int index = c - 'a';
                a[index]++;
            }
            counts.add(a);
        }
        System.out.println("==============================");

        int[] r = new int[26];
        for(int i = 0;i < 26;i++){
            int n = Integer.MAX_VALUE;
            for(int[] a:counts){
                n = Math.min(n,a[i]);
            }
            r[i] = n;
        }
        System.out.println(Arrays.toString(r));

        List<String>result = new ArrayList<>();
        for(int i = 0;i < 26;i++){
            for(int j = 0;j<r[i];j++) {
                char c = (char) ('a' + i);
                result.add(String.valueOf(c));
            }
        }
        return result;
    }

    public static void main(String[] args) {
        String[] A = {"bella","label","roller"};
        //commonChars(A);  测试第一步是否正确
        System.out.println(commonChars(A));
        System.out.println("=====================================");
        System.out.println(commonChar2(A));

    }
}
