package Sousuoshu;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
//1.纯key模型：set
//2.key-value 模型
/**
 * 查找
 * @param   key 关键字
 * @return 找到了返回对应的value，如果没有找到,返回-1
 */
public class BinarySearchTree {
    private static class Node{
        int val;
        int key;
        Node  left;
        Node right;
    }

    private Node root = null;
    public int get(int key){
        Node cur = root;
        while(cur != null){
            if(key == cur.key){
                return cur.val;
            }else if(key < cur.key){
                cur = cur.right;
            }else{
                cur = cur.left;
            }
        }
        return -1;
    }
    //打印所有value的值
    public int put(int key,int value){
        if(root == null){
            root = new Node();
            root.key = key;
            root.val = value;
            return -1;
        }

        Node parent = null;
        Node cur = root;
        while(cur != null){
            if(key == cur.key){
                int oldValue = cur.val;
                cur.val = value;
                return oldValue;
            }else if(key < cur.key){
                parent = cur;
                cur = cur.left;
            }else{
                parent = cur;
                cur = cur.right;
            }
        }
        Node node = new Node();
        node.key = key;
        node.val = value;

        if(key < parent.key){
            parent.left = node;
        }else{
            parent.right = node;
        }
        return -1;
    }

    //判断查找元素和树的结点是否相同
    public int getOrDefault(int key, int defaultValue){
        Node cur = root;
        while(cur!= null){
            if(key == cur.val){
                return cur.val;
            }else if(key < cur.key){
                cur = cur.left;
            }else{
                cur = cur.right;
            }
        }
        return defaultValue;
    }

    //打印所有Key的值
    //层序遍历（队列）
    public Set<Integer> keySet(){
        Set<Integer> result = new HashSet<>();
        if(root == null){
            return result;
        }
        Queue<Node>queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            Node front = queue.poll();
            result.add(front.key);
            if(front.left != null){
                queue.add(front.left);
            }

            if(front.right !=  null){
                queue.add(front.right);
            }
        }
        return result;
    }

    //中序遍历
    public Set<Integer>keySet2(){
        Set<Integer>set = new HashSet<>();
        inorderTraversal(set,root);
        return set;
    }

    private static void inorderTraversal(Set<Integer> set,Node n){
        if(n!=null){
            inorderTraversal(set,n.left);
            set.add(n.key);
            inorderTraversal(set,n.right);
        }
    }


    //搜索树的删除



}
