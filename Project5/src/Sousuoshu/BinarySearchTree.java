package Sousuoshu;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class BinarySearchTree {
    private static class Node{
        int val;
        int key;
        Node  left;
        Node right;

    }

    private Node root = null;
    public int get(int val,int key){
        while(root!= null){
            if(key == root.val){
                return root.val;
            }else if(key < root.key){

            }else{

            }
        }
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
        Queue.add(root);


    }

    //中序遍历


    //搜索树的删除



}
