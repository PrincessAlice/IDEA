package OneDayPractice.day7;


import java.util.Stack;
public class test11 {
        Stack<Integer> stack1 = new Stack<Integer>();
        Stack<Integer> stack2 = new Stack<Integer>();

        public void push(int node) {
            stack1.push(node);
        }

        public int pop() {
            Integer re = null;
            if(!stack2.isEmpty()) {
                re = stack2.pop();
            }else {
                while(!stack1.isEmpty()) {
                    re = stack1.pop();
                    stack2.push(re);
                }
                if(!stack2.isEmpty()) {
                    re = stack2.pop();
                }

            }
            return re;
        }

    public static void main(String[] args) {

    }
}
