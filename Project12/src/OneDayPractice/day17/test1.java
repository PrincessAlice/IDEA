package OneDayPractice.day17;


class Node{
    int val = 0;
    Node left = null;
    Node right=null;

    public Node(int val){
        this.val = val;
    }
}
public class test1 {
    public static void SameTree(Node root){
        if(root == null){
            return;
        }
        if(root.left==null&&root.right==null){
            return;
        }

        swap(root);

        if(root.left != null){
            SameTree(root.left);
        }

        if(root.right!=null){
            SameTree(root.right);
        }
    }

    private static void swap(Node root) {
        Node node = null;
        node = root.left;
        root.left = root.right;
        root.right = node;
    }


    public static void main(String[] args) {

    }

}
