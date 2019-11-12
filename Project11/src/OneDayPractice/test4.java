package OneDayPractice;

//用两个栈实现一个队列
import java.util.Scanner;
import java.util.Stack;

public class test4 {
    Stack<Integer> stack1 = new Stack<>();
    Stack<Integer> stack2 = new Stack<>();

    public void push(int node){
        stack1.push(node);
    }

    public int pop(){
        Integer re = null;
        if(!stack2.isEmpty()){
            re = stack2.pop();
        }else{
            while(!stack1.isEmpty()){
                re = stack1.pop();
                stack2.push(re);
            }

            if(!stack2.isEmpty()){
                re = stack2.pop();
            }
        }
        return  re;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Integer node = scanner.nextInt();

        System.out.println(node);
    }
}
