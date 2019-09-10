package jihe;

import java.util.HashSet;
import java.util.Set;

public class P2 {
    public static int numJewelsInStones(String J,String S){
        char[] a = J.toCharArray();
        char[] b = S.toCharArray();
        Set<Character>jewels = new HashSet<>();
        for(char ch: J.toCharArray()){
            jewels.add(ch);
        }
        int count = 0;
        for(char ch: S.toCharArray()){
            if(jewels.contains(ch)){
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {

    }
}
