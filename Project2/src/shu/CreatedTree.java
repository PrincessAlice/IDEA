package shu;

import java.util.ArrayList;
import java.util.List;

class TreeNode{
    char  val;
    TreeNode left = null;
    TreeNode right = null;
    TreeNode(char  val){
        this.val = val;
    }

    /*@Override
    public String toString() {
        return "root=" + val ;
    }*/     //没用
}

class CreatedTree {
    private List<Character> list;

    private static TreeNode Root() {
        TreeNode A = new TreeNode('A');
        TreeNode B = new TreeNode('B');
        TreeNode C = new TreeNode('C');
        TreeNode D = new TreeNode('D');
        TreeNode E = new TreeNode('E');
        TreeNode F = new TreeNode('F');
        TreeNode G = new TreeNode('G');


        A.left = B;
        B.left = D;
        D.left = null;
        D.right = null;
        B.right = E;
        E.left = null;
        E.right = null;

        A.right = C;
        C.left = F;
        F.left = null;
        F.right = null;
        C.right = G;
        G.left = null;
        G.right = null;
        return A;
    }

        private void preOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        list.add(root.val);
        preOrder(root.left);
        preOrder(root.right);
    }

    public List<Character> PreOrder(TreeNode root) {
        list = new ArrayList<>();
        preOrder(root);
        return list;
    }


    public static void main(String[] args) {
        CreatedTree c = new CreatedTree();
       /*for(char i=0;i<1000;i++){
             TreeNode root=new TreeNode(i);
             c.PreOrder(root);
        }*/    //没用
        System.out.println(c.PreOrder(Root()));
    }

}
