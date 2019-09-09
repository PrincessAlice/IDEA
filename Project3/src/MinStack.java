import java.util.Stack;
//有序数列进栈后，删除栈顶元素，返回栈内的最小元素

public class MinStack {
    Stack<Integer> normal = new Stack<>();
    Stack<Integer> min = new Stack<>();
    public MinStack(){ } //构造方法
    public void push(int x){
        normal.push(x);
        if(min.empty()) {
            min.push(x);
        }else{
            int m = min.peek();
            if(x <= m){
                min.push(m);
            }
        }
    }

    public void pop(){
        normal.pop( );
        min.pop();
    }

    public int top(){
       return  normal.peek(); //查看此栈顶部的对象
    }

    public int getMin(){
        return  normal.peek();
    }
}
