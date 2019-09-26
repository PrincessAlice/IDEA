package String类型;

import java.util.*;

public class roman {
    //通过查表来将罗马数字转换为int型
    public static  int romanToInt(String s){
        HashMap<Character,Integer> map = new HashMap<>();   //定义个表
        map.put('I',1);
        map.put('X',10);
        map.put('L',50);
        map.put('C',100);
        map.put('D',500);
        map.put('M',1000);

        HashMap<Character,List<Character>> special = new HashMap<>();  //特殊表
        special.put('I',Arrays.asList('V','X'));
        special.put('X',Arrays.asList('L','C'));
        special.put('C',Arrays.asList('D','M'));

        int n =0;
        for(int i =0;i<s.length();i++){
            char c = s.charAt(i);
            if(i < s.length()-1){
                char next = s.charAt(i+1);   //取下一个字符
                if(special.containsKey(c)){   //在special表中查找 c 字符是否存在
                    if(special.get(c).contains(next)){
                        int nextInt = map.get(next);
                        int curInt = map.get(c);
                        n += (nextInt-curInt);
                        i++;
                        continue;
                    }
                }
            }

        }
        return n;
    }

    //M CM XC IV = 1994
    public static void main(String[] args) {
        System.out.println(romanToInt("V"));
        System.out.println(romanToInt("VII"));

    }
}
