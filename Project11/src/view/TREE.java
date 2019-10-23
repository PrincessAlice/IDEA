package view;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

class TreeNode{
    int value;
    TreeNode left;
    TreeNode right;
}

public class TREE {
    //非递归后序遍历 栈
    public static void postOrder(TreeNode root){
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        TreeNode last = null;   //上一个被打印的结点

        while(cur != null || !stack.isEmpty()){
            while(cur != null){
                cur = cur.left;
                stack.push(cur);
            }
            TreeNode top = stack.peek(); //记录栈顶元素
            if(top.right == null || top.right == last){
                System.out.println(top.value);
                stack.pop();  //出栈
                last = top;
            }else{
                cur = top.right;
            }
        }
    }

    //另一种写法
    public static List<List<Integer>> levelOrder2(TreeNode root){
        return null;
    }
    //层序遍历 队列
    public static void levelOrder(TreeNode root){
        if(root == null){
            return;
        }
        Queue<TreeNode>queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            TreeNode front = queue.poll();
            System.out.println(front.value);
            if(front.left != null){
                queue.offer(front.left);
            }
            if(front.right != null){
                queue.offer(front.right);
            }
        }
    }

    //判断两个树是否相同
    private static boolean SameTree(TreeNode p,TreeNode q){
        //1
        if(p == null && q == null){
            return true;
        }
        if(p == null || q == null ){
            return false;
        }
        return  p.value == q.value && SameTree(p.left,q.left)&&SameTree(p.right,q.right);
    }

    private static boolean isSameTree(TreeNode m,TreeNode n){
        if( m == null || n == null){
            if(m == null && n == null){
                return true;
            }
            return false;
        }
        return m.value == n.value && isSameTree(m.left,n.left) && isSameTree(m.right,n.right);
    }
}
