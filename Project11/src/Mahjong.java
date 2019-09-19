package 琐碎知识点;

import java.util.*;

//覆写与不覆写的例子对比
//麻将
public class Mahjong implements Comparable<Mahjong> {

    public String  color;
    public String value;

    public Mahjong(String color,String value){
        this.color = color;
        this.value = value;
    }

    @Override
    public int compareTo(Mahjong o){
        return this.value.compareTo(o.value);
    }
}
