package String类型;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class MyString implements Comparable<MyString>{ //final 为了类不被
    private final char[] value;
    //public 的方法列出
    // 需要复制数组，保证数组的引用不会被泄漏
    // 泄漏会导致通过泄漏的引用，修改属性的值
    // 从而破坏对象的不可变特性
    public MyString(char value[]){
        this.value = Arrays.copyOf(value,value.length);
    }

    public MyString(char value[],int offset,int count){  //直接拷贝引用
        this.value = Arrays.copyOfRange(value,offset,offset+count);
    }

    // 这里引用泄漏没有问题，因为新的对象也不会去修改
    // value 数组中的值
    // 相比较于 copyOf，可以省去复制的时间，提升效率
    public MyString(MyString s){
        this.value = s.value;
    }

    //模拟的对象常量池
    private static List<MyString> pool = new ArrayList<>();
    //模拟直接定义字符串，会直接入池
    public static MyString literal(MyString s){
        for(MyString ms:pool){
            if(ms.equals(s)){
                return ms;
            }
        }
        MyString rs = new MyString(s);
        pool.add(rs);
        return rs;
    }

    //手动入池
    //如果常量池中已经有该相等的对象，返回引用
    // 否则在常量池中创建对象，并返回引用
    public MyString intern(){
        for (MyString ms:pool){
            if(ms.equals(this)){
                return ms;
            }
        }
        MyString rs = new MyString(this);
        pool.add(rs);
        return rs;
    }

    public char charAt(int index){
        return value[index];
    }

    //不能直接返回引用，防止引用泄漏
    public char[] toCharArray(){
        return Arrays.copyOf(value,value.length);
    }

    //不区分大小写的比较
    public boolean equalsIgnoreCase(MyString s){
        //return toUpper().equals(s.toUpper()); 可行但效率低
        if(s == null){
            return false;
        }
        if(value.length != s.value.length){
            return false;
        }
        for(int i =0;i < value.length;i++){
            char a = value[i];
            char b = s.value[i];
            if( a == b){
                continue;
            }
            if(a >= 'a' && a <= 'z'){
                a += ('A'-'a');
                if(a == b){
                    continue;
                }
            }else if(a >= 'A'&& a <= 'Z'){
                a += ('a'-'A');
                if(a == b){
                    continue;
                }
            }
        }
        return true;
    }
    @Override //区分大小写的比较
    public boolean equals(Object s){
        if(this == s){     //判断引用是否指向同一个对象
            return true;
        }
        if(s == null){  //判断 s 是否为null
            return false;
        }

        //s.getClass() == getClass()
        if (!(s instanceof MyString)){  //判断s是不是一个MyString 类型的对象
            return false;
        }
        //比较属性的相等性
        return Arrays.equals(value,((MyString)s).value);  //比较数组内部的值是否相等
    }
    @Override  //比较两个字符串的大小关系
    public int compareTo(MyString o){
        if(o == null){
            return 1;
        }
        int length = Math.min(value.length,o.value.length);
        for(int i =0;i<length;i++){
            char a = value[i];
            char b = o.value[i];
            if(a<b){
                return -1;
            }else if(a>b){
                return 1;
            }
        }
        if(value.length >o.value.length){
            return 1;
        }else if(value.length < o.value.length){
            return -1;
        }else{
            return 0;
        }
    }
    //转大写
    public MyString toUpper(){
        //保证对象的不可变性
        //1.构造新的对象
        //2.遍历新对象的value
        //3.把小写字母变成大写
        //4.返回新的对象
        //char[] v = Arrays.copyOf(value,value.length);
        MyString s = new MyString(value);
        //MyString t = new MyString(this);  会全部都修改
        for(int i =0;i<s.value.length;i++){
            if(s.value[i] >= 'a' && s.value[i] <= 'z'){
                s.value[i] = (char)(s.value[i] -'a'+'A');
            }
        }
        return s;
    }

    public MyString toLower(){
        MyString t = new MyString(value);  //构造对象
        for(int i=0;i<t.value.length;i++){  //遍历
            if(t.value[i] >= 'A'&& t.value[i] <= 'Z'){
                t.value[i] = (char)(t.value[i] -'A'+'a');
            }
        }
        return t;
    }


    //截取部分字符串
    public MyString substring(int begin,int end){
        return new MyString(value,begin,end-begin);  //直接拷贝一份
    }

    @Override
    public int hashCode(){
        int hash =0;        //保证相等即hash值相等
        for(char c:value){
            hash = (hash^c);  //异或
        }
        return hash;
    }

    @Override
    public String toString(){
        return new String(value);
    }


    public static void main(String[] args) {
        char[] a = {'a','b','c'};
        MyString s = new MyString(a);
        MyString t = new MyString(s);
        System.out.println(s);
        System.out.println(t);
        System.out.println(s.equals(t));
        MyString r = t.toUpper();
        System.out.println(s);
        System.out.println(t);
        System.out.println(r);
        System.out.println(s.equals(t));
        a[0] = 'z';
        System.out.println(s);
        System.out.println(t);
        System.out.println(s.equals(t));
        System.out.println("abcde".compareTo("abc"));
    }
}
