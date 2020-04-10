package shu;

import java.util.TreeMap;

public class Main {
    public static void main(String[] args) {
        TreeMap<Integer,String> treeMap = new TreeMap<>();
        treeMap.put(18,"18");
        //利用的是key的有序特点
        treeMap.ceilingKey(18);
        //返回18或者比18大的key中最小的一个key


        treeMap.floorKey(18);
        //返回18或者比181小的key中最大的一个key
    }
}
