package mianshiti;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Node{
    int value;
    Node left;
    Node right;
    Node(int value){
        this.value=value;
    }
}

public class Solution {

    public static int Height(Node root){
        if(root == null){
            return 0;
        }
        int left = Height(root.left);
        int right = Height(root.right);
        int big = Math.max(left,right)+1;
        return big;
    }
/**
 * 平衡树的条件:
 *（1）空树是平衡的
 *（2）左子树是平衡的
 *（3）右子树是平衡的
 *（4）左右子树的高度差的绝对值不超过1
 * */
    public boolean isBalanced(Node root){
        if(root == null){
            return true;
        }
        boolean leftBalance = isBalanced(root.left);
        if(!leftBalance){
            return false;
        }
        boolean rightBalance = isBalanced(root.right);
        if(!rightBalance){
            return false;
        }
        int leftHeight = Height(root.left);
        int rightHeight = Height(root.right);
        int diff = leftHeight - rightHeight;
        if(diff<-1||diff>1){
            return false;
        }
        return true;
    }

    //二叉树构建字符串
    public static void preOrder(StringBuilder s,Node root){
        if(root == null){
            return;
        }
        s.append("(");
        s.append(root.value);
        if(root.left == null&&root.right!=null){
            s.append("()");
        }else{
            preOrder(s,root.left);
        }
        preOrder(s,root.left);
        s.append(")");
    }

    public static String tree2str(Node t){
        if(t == null){
            return"";
        }
        StringBuilder S = new StringBuilder();
        preOrder(S,t);
        String r= S.toString();
        return r.substring(1,r.length()-1);
    }

    //查找结点是否在树中
    public  static boolean search(Node root,Node p){
        if(root == null){
            return false;
        }
        if(root == p){
            return true;
        }
        if(search(root.left,p)){
            return true;
        }
        return search(root.right,p);
    }

    //找最近公共祖先
    public Node lowestCommonAncestor(Node root,Node p, Node q){
        if(root==p&&root==q){
            return root;
        }
        boolean pInLeft = search(root.left,p);
        boolean qInLeft = search(root.left,q);
        if(pInLeft&&qInLeft){
            return lowestCommonAncestor(root.left,p,q);

        }
        if(!pInLeft&&!qInLeft){
            return lowestCommonAncestor(root.right,p,q);
        }
        return root;
    }

    //层序遍历(队列)
    //输出{A,B,C,D}
    public static void levelOrderTraversal(Node root){
        if(root == null){
            return;
        }
        Queue<Node>queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            Node front = queue.poll(); //取出队首元素
            System.out.println(front.value);
            if(front.left !=null){
                queue.add(front.left);
            }
            if(front.right!=null){
                queue.add(front.right);
            }
        }
    }




}
