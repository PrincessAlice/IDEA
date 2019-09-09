import java.util.Stack;

//用栈实现队列
public class MyQueueWithStack {
    private Stack<Integer> stack1 = new Stack<>();
    private Stack<Integer> stack2 = new Stack<>();
    public void push(int x){
        stack1.push(x);
    }

    public int pop(){
        if(stack2.empty()){
            while(!stack1.empty()){
                int v= stack1.pop();
                stack2.pop();
            }
        }
        return stack2.pop();
    }

    public int peek(){
        if(stack2.empty()){
            while(!stack1.empty()){
                int v = stack1.peek();
                stack2.peek();
            }
        }
        return stack2.peek();
    }

    public boolean empty(){
        return stack1.empty()&&stack2.empty();
    }

}


