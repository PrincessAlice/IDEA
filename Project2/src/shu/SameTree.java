package shu;

public class SameTree {
    private static boolean isSameTree(Node1 p ,Node1 q){
        if(p==null&&q==null){
            return true;
        }
        if(p==null||q==null){
            return false;
        }
        if(p.value==q.value) {
            return true;
        }
        if(isSameTree(p.left,q.left)&&isSameTree(p.right,q.right)) {
            return true;
        }
        return p.value==q.value&&isSameTree(p.left,q.left)&&isSameTree(p.right,q.right);
    }


    //判断是否为镜像树
    public static boolean isMirror(Node1 p,Node1 q){
        if(p==null&&q==null){
            return true;
        }
        if(p==null||q==null){
            return false;
        }
        if(p.value==q.value){
            return true;
        }
        if(isMirror(p.left,q.right)&&isMirror(p.right,q.left)){
            return true;
        }
        return p.value==q.value&&isMirror(p.left,q.right)&&isMirror(p.right,q.left);
    }

    //判断子树是否为另一个树的子树
    //首先判断root 和t是否相同，递归判断root的左子树和t是否相同，递归判断root的右子树和t是否相同
    public static boolean isSubTree(Node1 root,Node1 t){
        if(root == null||t==null){
            return false;
        }
        return isSameTree(root,t)||isSubTree(root.left,t)||isSubTree(root.right,t);
    }


    public static void main(String[] args) {

    }


}
