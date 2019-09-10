package huan;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

class Node{
    int val;
    Node left;
    Node right;
}

public class test1 {
     private static void postorder(Node root){
         Stack<Node>stack = new Stack<>();
         Node cur = root;
         Node last = null;      //上一个被三次经过的结点
         while (!stack.empty()|| cur!=null){
             while(cur!=null){
                 stack.push(cur);
                 cur = cur.left;
             }
             Node top = stack.peek();
             if(top.right == null || top.right == last ){   //条件成立一个元素均出栈
                 stack.pop();
                 System.out.println(top.val);
                 last = top;
             }else{
                 cur = top.right;
             }
         }
     }

    //判断是否为完全二叉树
    public static boolean isComplete(Node root){
        if(root == null){
            return true;
        }
        //层序遍历，直到遇到null
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while(true){
            Node front = queue.poll();
            if(front == null){
                break;
            }
            queue.add(front.left);
            queue.add(front.right);
        }
        //判断队列中剩余元素是否都是null
        while(!queue.isEmpty()){
            Node node = queue.poll();
            if(node!= null){
                return false;
            }
        }
        return true;
    }

    public static void heapify(int[] array,int size,int index){
        while(true){
            int left = 2*index +1;
            if(left >= size){
                return;
            }
            int max = left;
            if(left+1<size){
                if(array[left+1]>array[left]){
                    max = left+1;
                }
            }
            if(array[index] >= array[max]){
                return;
            }
            swap(array,index,max);
            index = max;
        }
    }

    private static void swap(int[]array,int i,int j){
        int t = array[i];
        array[i] = array[j];
        array[j] = t;
    }

    public static void main(String[] args) {
        Node n1 = new Node();
        n1.val = 1;
        n1.left = new Node();
        n1.left.val = 2;
        n1.right = new Node();
        n1.right.val = 3;
        n1.left.left = new Node();
        n1.left.left.val = 4;
        //postorder(n1);

        int[] array = {-1,8,4,6,7,2,3,1,0};
        heapify(array,array.length,0);
        System.out.println(Arrays.toString(array));
    }
}
