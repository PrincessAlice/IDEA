package huan;

import java.util.Stack;

public class test1 {
    //前序遍历的非递归写法
    public static void preOrder(Node root){
        Stack<Node>stack = new Stack<>();
        Node cur = root;
        while(!stack.empty()||cur!=null){
            while(cur!=null){
                System.out.println(cur.val);
                stack.push(cur);
                cur = cur.left;
            }
            Node top = stack.pop();
            cur = top.right;
        }
    }

    public static void inOrder(Node root){
        Stack<Node>stack  = new Stack<>();
        Node cur = root;
        while(!stack.empty()||cur!=null){
            while(cur!=null){
                stack.push(cur);
                cur =cur.left;
            }
            Node top = stack.pop();
            System.out.println(top.val);
            cur = top.right;
        }
    }


    public static void main(String[] args) {
        Node n1 = new Node();
        n1.val = 1;
        n1.left = new Node();
        n1.left.val = 2;
        n1.right = new Node();
        n1.right.val = 3;
        n1.left.left = new Node();
        n1.left.left.val = 4;

        //preOrder(n1);
            inOrder(n1);
    }

}
