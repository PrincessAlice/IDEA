package String类型;

import java.util.Arrays;

public final class MyString implements Comparable<MyString>{ //final 为了类不被
    private char[] value;
    //public 的方法列出
    public MyString(char Value[]){
        this.value = Arrays.copyOf(value,value.length);
    }

    public MyString(char value[],int offset,int count){  //直接拷贝引用
        this.value = Arrays.copyOfRange(value,offset,offset+count);
    }

    public MyString(MyString s){
        this.value = s.value;
    }

    //模拟直接定义字符串，会直接入池
   // public MyString(boolean intern){}
    //public MyString intern(){}

    public char charAt(int index){
        return value[index];
    }

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

    }
}
