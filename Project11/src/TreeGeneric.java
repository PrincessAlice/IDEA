package view;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//层序遍历的泛型类
class Node<E>{
    E val;
    Node<E>left;
    Node<E>right;

    Node(E e){
        this.val = e;
    }
}

class Pair<E>{
    Node<E> node;
    int level;

    Pair(Node<E> node,int level){
        this.node = node;
        this.level = level;
    }
}

public class TreeGeneric {
    public static <E> List<List<E>> levelOrder(Node<E> root){
        Queue<Pair<E>> queue = new LinkedList<>();
        queue.offer(new Pair<>(root,0));
        List<List<E>> ret = new ArrayList<>();
        while(!queue.isEmpty()){
            Pair<E> front = queue.poll();
            if(ret.size() == front.level){
                ret.add(new ArrayList<>());
            }
            ret.get(front.level).add(front.node.val);
            if(front.node.left != null){
                queue.offer(new Pair<>(front.node.left,front.level+1));
            }
            if(front.node.right != null){
                queue.offer(new Pair<>(front.node.right,front.level +1));
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        Node<Integer> n1 = new Node<>(1);
        Node<Integer> n2 = new Node<>(2);
        Node<Integer> n3 = new Node<>(3);
        Node<Integer> n4 = new Node<>(4);
        Node<Integer> n5 = new Node<>(5);

        n1.left = n2;n1.right = n3;
        n2.left = n4;n3.right = n5;

        List<List<Integer>> r = levelOrder(n1);
        System.out.println(r);
    }
}
