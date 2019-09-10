package jihe;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class SetDemo {
    public static void main(String[] args){
        Set<String> set = new HashSet<>();
        set.add("hello");
        set.add("sister");
        set.add("hello");
        set.add("brother");

        System.out.println(set);
        System.out.println(set.contains("hello"));
        System.out.println(set.contains("Lihanhaun"));

        Iterator<String> it = set.iterator();
        while(it.hasNext()){
            System.out.println(it.next());
        }

        for(String s:set){
            System.out.println(s);
        }
    }
}
