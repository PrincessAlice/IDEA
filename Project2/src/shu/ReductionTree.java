package shu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//还原树(构造树)
public class ReductionTree {
    public static void preOrderTraversal(Node1 root){  //根+左子树+右子树
        if(root == null){
            return;
        }
        System.out.println(root.value);
        preOrderTraversal(root.left);
        preOrderTraversal(root.right);
    }

    public static void inOrderTraversal(Node1 root){//左子树+根+ 右子树
        if(root == null){
            return;
        }
        inOrderTraversal(root.left);
        System.out.println(root.value);
        inOrderTraversal(root.right);
    }

    public static void postOrderTraversal(Node1 root){  //左子树+右子树+根
        if(root == null){
            return;
        }
        postOrderTraversal(root.left);
        postOrderTraversal(root.right);
        System.out.println(root.value);
    }

   //前序+中序
    private static Node1 buildTree1(List<Character>preOrderTraversal,List<Character>inOrderTraversal){
        if(preOrderTraversal.size() == 0){
            return null;
        }
        char rootValue = preOrderTraversal.get(0);
        int leftCount = inOrderTraversal.indexOf(rootValue);
        Node1 root = new Node1(rootValue);
        List<Character>leftPreOrder = preOrderTraversal.subList(1,1+leftCount);
        List<Character>leftInOrder = inOrderTraversal.subList(0,leftCount);
        Node1 left = buildTree1(leftPreOrder,leftInOrder);
        root.left = left;
        List<Character>rightPreOrder = preOrderTraversal.subList(1+leftCount,preOrderTraversal.size());
        List<Character>rightInOrder = inOrderTraversal.subList(leftCount+1,inOrderTraversal.size());
        Node1 right = buildTree1(rightPreOrder,rightInOrder);
        root.right = right;
        return root;
    }

    //中序+后序
    private static Node1 buildTree2(List<Character>inOrderTraversal,List<Character>postOrderTraversal){
        if(inOrderTraversal.size() == 0){
            return null;
        }
        int last = postOrderTraversal.size()-1;
        char rootValue = postOrderTraversal.get(last);
        int leftCount = inOrderTraversal.indexOf(rootValue);
        Node1 root = new Node1(rootValue);
        List<Character>leftInOrder = inOrderTraversal.subList(0,leftCount);
        List<Character>leftPostOrder = postOrderTraversal.subList(0,leftCount);
        List<Character>rightInOrder = inOrderTraversal.subList(leftCount+1,inOrderTraversal.size());
        List<Character>rightPostOrder = postOrderTraversal.subList(leftCount,postOrderTraversal.size()-1);

        root.value = rootValue;
        //root.left = buildTree2(inOrderTraversal,postOrderTraversal);
        //root.right1 = buildTree2(inOrderTraversal,postOrderTraversal);
        return root;
    }

    public static void main(String[] args) {
        List<Character>preOrderTraversal = Arrays.asList('A','B','D','E','G','C','F','H');
        List<Character>inOrderTraversal = Arrays.asList('D','B','G','E','A','C','F','H');
        List<Character>postOrderTraversal = Arrays.asList('D','G','E','B','H','F','C','A');
        Node1 root = buildTree1(preOrderTraversal,inOrderTraversal);
        System.out.println("成功");
        Node1 root1 = buildTree2(inOrderTraversal,postOrderTraversal);
        System.out.println("成功");
        //System.out.println(root.val);

    }
}
