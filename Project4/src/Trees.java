import java.util.*;
/*
* 层序遍历（线性表）
* 输出为{{A},{B,C},{D}}
* */

 class Element{
    TreeNode node;
    int level;
}
public class Trees {

    public List<List<Integer>>levelOrder(TreeNode root){
        List<List<Integer>>retList = new ArrayList<>();
        if(root == null){
            return retList;
        }
        Queue<Element>queue = new LinkedList<>();
        Element e = new Element();
        e.node = root;
        e.level = 0;
        //Element e= new Element(root,0);
        queue.add(e);
        while(!queue.isEmpty()){
            Element front = queue.poll();
            //如果层数等于线性表的大小，则需要在线性表中加一个线性表，在线性表以层数为下标添加元素
            if(front.level == retList.size()){      //一层结点加完，再加层
                retList.add(new ArrayList<>());
            }
            retList.get(front.level).add(front.node.value);//同层内加结点
            if(front.node.left!=null){
                Element L = new Element();
                L.node = front.node.left;
                L.level = front.level+1;
                queue.add(L);
            }
            if(front.node.right!=null){
                Element R = new Element();
                R.node = front.node.right;
                R.level = front.level+1;
            }
        }
        return retList;
    }

    //判断是否为完全二叉树
    public static boolean isComplete(TreeNode root){
        if(root == null){
            return true;
        }
        //层序遍历，直到遇到null
        Queue<TreeNode>queue = new LinkedList<>();
        queue.add(root);
        while(true){
            TreeNode front = queue.poll();
            if(front == null){
                break;
            }
            queue.add(front.left);
            queue.add(front.right);
        }
        //判断队列中剩余元素是否都是null
        while(!queue.isEmpty()){
            TreeNode node = queue.poll();
            if(node!= null){
                return false;
            }
        }
        return true;
    }

    //前序遍历的非递归写法
    public static void preorderNoR(TreeNode root){
        Stack<TreeNode>stack = new Stack<>();
        TreeNode cur = root;
        while(!stack.empty()||cur!=null){
            while(cur!=null){
                System.out.println(cur.value);
                stack.push(cur);
                cur = cur.left;
            }
            TreeNode top = stack.pop();
            cur = top.right;
        }
    }

    //中序遍历的非递归
    public static void inorderNoR(TreeNode root){
        Stack<TreeNode>stack = new Stack<>();
        TreeNode cur = root;

        while (!stack.empty()||cur!=null){
            while(cur!=null){
                stack.push(cur);
                cur = cur.left;
            }
            TreeNode top = stack.pop();
            System.out.println(top.value);
            cur = top.right;
        }
    }

    //后序遍历的非递归
    private static void postorderNoR(TreeNode root){
        Stack<TreeNode>stack =new Stack<>();
        TreeNode cur = root;
        TreeNode last = null;       //  上一个被三次完整经过的结点
        while (!stack.empty()||cur!=null){
            while(cur!=null){
            stack.push(cur);
            cur = cur.left;
            }
            TreeNode top = stack.peek();
            if(top.right == null||top.right == last){
                stack.pop();
                System.out.println(top.value);
                last = top;
            }else{
                cur = top.right;
            }
        }
    }

    public static void main(String[] args) {
        TreeNode n1 = new TreeNode();
        n1.value = 1;
        n1.left = new TreeNode();
        n1.left.value = 2;
        n1.right = new TreeNode();
        n1.right.value = 3;
        n1.left.left = new TreeNode();
        n1.left.left.value = 4;

        //preorderNoR(n1);
        //postorderNoR(n1);
        inorderNoR(n1);

    }

}
