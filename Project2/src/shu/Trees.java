package shu;

 class Node1{
    char value;
    Node1 left = null;
    Node1 right = null;
    Node1(char value){
        this.value = value;
    }

}

public class Trees {

    private static Node1 createdRoots(){
        Node1 A = new Node1('A');
        Node1 B = new Node1('B');
        Node1 C = new Node1('C');
        Node1 D = new Node1('D');
        Node1 E = new Node1('E');
        Node1 F = new Node1('F');
        Node1 G = new Node1('G');
        Node1 H = new Node1('H');

        A.left = B;B.left = D;D.left = null;D.right =null;B.right = E;
        E.left = null;E.right = H;H.left = null;H.right = null;

        A.right = C;C.left = F;F.left = null;F.right = null;C.right = G;
        G.left = null;G.right = null;
        return A;

    }

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

    //计算二叉树中的结点个数
    //法一：遍历思想
    public static int count = 0;
    public static int calcCount1(Node1 root){
        if(root == null){
            return 0;
        }
        count ++;
        calcCount1(root.left);
        calcCount1(root.right);
        return count;
    }
    //法二：汇总（递归）
    public static int  calcCount2(Node1 root){
        if(root == null){
            return 0;
        }

        int left = calcCount2(root.left);
        int right = calcCount2(root.right);
        int count=left + right + 1;
        return count;
    }

    //计算叶子结点的个数
    //法一：遍历
    public static int leafCount = 0;
    public static void  LeafCount(Node1 root){
        if(root == null){
            return;
        }
        LeafCount(root.left);
        if(root.left ==null && root.right == null){
            //++leafCount;
            leafCount++;
        }
        //preOrderTraversal(root.left);
        //preOrderTraversal(root.right);
        LeafCount(root.right);
        return ;
    }
    //法二：汇总
    public static int LeafCount1(Node1 root){
        if(root == null){
            return 0;
        }
        //表示一个结点的树
        if(root.left==null&&root.right==null){
            return 1;
        }
        return LeafCount1(root.left)+LeafCount1(root.right);
    }

    //求树的高度
    public static int calcHeight(Node1 root){
        if(root == null){
            return 0;
        }
        int left = calcHeight(root.left);
        int right = calcHeight(root.right);
        int height = Math.max(left,right)+1;
        return height;
    }

    //求树的第K层的结点个数
    public static int calcKLevel(Node1 root,int k){
        if(root == null){
            return 0;
        }
        if(k==1){
            return 1;
        }
        int left = calcKLevel(root.left,k-1);
        int right = calcKLevel(root.right,k-1);
        int count = left+right;
        return count;
    }

    //查找
    public static Node1 search(Node1 root,int val){
        if(root == null){
            return null;
        }
        if(root.value == val ){
            return root;
        }
        //去左子树查找
        Node1 left = search(root.left,val);
        if(left!=null) {
            return left;
        }
        //去右子树查找
        Node1 right = search(root.right,val);
        if(right!= null){
            return right;
        }
        return null;
    }

    //查找返回true/false
    public static boolean search1(Node1 root,int val){
        if(root == null){
            return false;
        }
        if(root.value == val){
            return true;
        }
        if(search1(root.left,val)){
            return true;
        }
        return search1(root.right,val);
    }


    public static void main(String[] args) {
        Node1 root = createdRoots();
//        preOrderTraversal(root);
//        System.out.println("================================");
//        inOrderTraversal(root);
//        System.out.println("=================================");
//        postOrderTraversal(root);
        System.out.println("=================================");
        System.out.println(calcHeight(root));
        System.out.println(calcKLevel(root,2));

    }

}

