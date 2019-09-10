package Sousuoshu;

import java.util.*;

public class P1 {
    private static class Node {
        int val;
        int key;
        Node left;
        Node right;
    }

    private Node root = null;

    public static class Entry {
        private int key;
        private int val;

        public int getKey() {
            return key;
        }

        public int getVal() {
            return val;
        }
    }

    //返回所有的键值对
    //public Set<Map.Entry<Integer,Integer>>entrySet()
    public Set<Entry> entrySet1() {        //通过层序遍历的方式
        Set<Entry> set = new HashSet<>();
        if (root == null) {
            return set;
        }

        Queue<Node> queue = new LinkedList<>();


        return set;
    }

    //
    public boolean containsKey(int key){

    }
    //
    public boolean containsValue(int val){}
}


