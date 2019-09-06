package shu;


import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Node2{
    int val;
    Node2 left;
    Node2 right;
//    Node2(int val){
//        this.val = val;
//    }
}

public class tree {

    //用数组构建树
    public static Node2 buildTreeArray(int[] inOrder,int[] postOrder){
        if(inOrder.length==0){
            return null;
        }
        int rootValue = postOrder[postOrder.length-1];
        int leftCount = -1;
        for(int i=0;i<inOrder.length-1;i++){
            if(inOrder[i]==rootValue){
                leftCount = i;
            }
        }
        int[] leftInOrder =Arrays.copyOfRange(inOrder,0,leftCount);
        int[] leftPostOrder = Arrays.copyOfRange(postOrder,0,leftCount);
        int[] rightInOrder = Arrays.copyOfRange(inOrder,leftCount+1,inOrder.length);
        int[] rightPostOrder = Arrays.copyOfRange(postOrder,leftCount,postOrder.length-1);
        Node2 root = new Node2();
        root.val = rootValue;
        root.left = buildTreeArray(leftInOrder,leftPostOrder);
        root.right = buildTreeArray(rightInOrder,rightPostOrder);
        return root;

    }

    //用带有空结点的前序遍历构建二叉树
    public static class ReturnValue{
        Node2 root;
        int used;
    }
    public static ReturnValue buildTreePreorder(List<Integer>preOrder){
        if(preOrder.size() == 0){
            ReturnValue rv = new ReturnValue();
            rv.root = null;
            rv.used = 0;
            return rv;
        }
        int rootValue = preOrder.get(0);
        if(rootValue == '#'){
            ReturnValue rv = new ReturnValue();
            rv.root = null;
            rv.used = 0;
            return rv;
        }
        ReturnValue leftRV = buildTreePreorder(preOrder.subList(1,preOrder.size()));
        ReturnValue rightRV = buildTreePreorder(preOrder.subList(1+leftRV.used,preOrder.size()));
        Node2 root = new Node2();
        root.val = rootValue;
        root.left = leftRV.root;
        root.right = rightRV.root;
        ReturnValue rv = new ReturnValue();
        rv.root = root;
        rv.used = 1+leftRV.used + rightRV.used;
        return rv;
    }
    //层序遍历(队列)
    private static void levelOrderTraversal(Node2 root){
        if(root == null){
            return;
        }
        Queue<Node2>queue = new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty()){
            Node2 front = queue.poll(); //取出队首元素
            System.out.println(front.val);
            if(front.left !=null){
                queue.add(front.left);
            }
            if(front.right!=null){
                queue.add(front.right);
            }
        }
    }

    public static void main(String[] args) {
        List<Integer>preOrder = Arrays.asList(1,2,3,(int)'#',(int)'#',(int)'#',
                4,(int)'#',5,(int)'#',(int)'#');
        ReturnValue rv = buildTreePreorder(preOrder);
        levelOrderTraversal(rv.root);

    }
}
