package 琐碎知识点;

public class Card {
    public int value;
    public String color;

    public Card(int value,String color){
       this.value = value;
       this.color = color;
    }

    //覆写 hashCode(),保证程序正常工作
    @Override
    public int hashCode(){
        return value ^ color.hashCode();  // 这里^ 表示异或
    }

    //很重要的方法
    @Override
    public boolean equals(Object obj){
        if(this == obj){
            return true;
        }
        if(obj == null){
            return false;
        }

        //if(obj.getClass()== this.getClass()){}
        if(!(obj instanceof  Card)){
            return false;
        }

        Card c=(Card)obj;
        return value == c.value && color.equals(c.color);
    }

}
