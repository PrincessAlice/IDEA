package Sousuoshu;

//泛型类
//TreeMap 背后是搜索树的结构或者说是红黑树
import java.util.Comparator;

//这里的K,V是类型变量，形参
public class MyTreeMap<K,V> {
    //这里的M,N是类型变量，形参
    public static class Entry<M,N>{
        //这里的M,N是类型变量，是M,N背后的
        private M key;
        private N value;

        private Entry<M,N>left;
        private Entry<M,N>right;
    }

    private Entry<K,V>root;
    private Comparator<K> comparator = null;
    public MyTreeMap(Comparator<K>comparator){
        this.comparator = comparator;
    }


}
