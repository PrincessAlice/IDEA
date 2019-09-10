package jihe;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MapDemo {
    public static void main(String[] args){
        //Integer  -> String
        Map<Integer,String> map = new HashMap<>();
        map.put(1,"hello");
        map.put(1,"hello");
        map.put(2,"Java");
        map.put(3,"Bit");
        map.put(100,"Bit");

        System.out.println(map);

        System.out.println(map.get(2));
        System.out.println(map.getOrDefault(4,"默认值"));
        System.out.println(map);

        for(int i:map.keySet()){
            System.out.println(i);
        }

        for(String value : map.values()){
            System.out.println(value);
        }

        Set<Map.Entry<Integer,String>> entries = map.entrySet();
        for(Map.Entry<Integer,String>entry : entries){
            System.out.println(entry.getKey());
            System.out.println(entry.getValue());
        }
    }
}
