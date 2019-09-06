package shu;

import java.util.ArrayList;
import java.util.List;

class Node{
    char val;
    Node left = null;
    Node right = null;
    Node(char val){
        this.val = val;
    }
}

public class Solution {
    private static Node createdroot(){
        Node A = new Node('A');
        Node B = new Node('B');
        Node C = new Node('C');
        Node D = new Node('D');
        Node E = new Node('E');
        Node F = new Node('F');
        Node G = new Node('G');
        Node H = new Node('H');

        A.left = B;B.left = D;D.left = null;D.right =null;B.right = E;
        E.left = null;E.right = H;H.left = null;H.right = null;

        A.right = C;C.left = F;F.left = null;F.right = null;C.right = G;
        G.left = null;G.right = null;
        return A;

    }

    public static List<Character> preOrder(Node root){     //创建了好多list有好多ArrayList对象，最后进行合并返回一个ArrayList
        if(root == null){
            return new ArrayList<>();
        }
        List<Character>list = new ArrayList<>();
        List<Character>leftPreOrder = preOrder(root.left);
        List<Character>rightPreOrder = preOrder(root.right);
        list.add(root.val);         //
        list.addAll(leftPreOrder);  //合并list
        list.addAll(rightPreOrder);
        return list;

    }

    public static List<Character>inOrder(Node root){
        if(root == null){
            return new ArrayList<>();
        }

        List<Character>leftInOrder = inOrder(root.left);
        List<Character>list = new ArrayList<>();
        List<Character>rightInOrder = inOrder(root.right);
        //list.add(root.val);
        list.addAll(leftInOrder);
        list.add(root.val);
        list.addAll(rightInOrder);
        return list;
    }

    public static List<Character>postOrder(Node root){
        if(root == null){
            return new ArrayList<>();
        }
        List<Character>leftPostOrder = postOrder(root.left);
        List<Character>rightPostOrder = postOrder(root.right);
        List<Character>list = new ArrayList<>();
        list.addAll(leftPostOrder);
        list.addAll(rightPostOrder);
        list.add(root.val);
        return list;
    }

    public static void main(String[] args) {
        Node root = createdroot();
        System.out.println(preOrder(root));
        System.out.println(inOrder(root));
        System.out.println(postOrder(root));
    }
}
