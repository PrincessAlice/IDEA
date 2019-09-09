//用链表实现队列
public class MyQueue {
    static class Node{
        int value;
        Node next = null;
        Node(int value){
            this.value = value;
        }
    }

    private Node front = null;
    private Node rear  = null;
    private int size = 0;
    public void push(int element){      //尾插
        size++;
        if(rear!=null){
            rear.next = new Node(element);
            rear.next = rear;
        }else{
            front =rear = new Node(element);
        }
    }

    public int pop(){                //删除队列首元素，并返回该元素的值
        int element = front.value;
        size--;
        front = front.next;
        if(front == null){
            rear = null;
        }
        return element;
    }

    public int rear(){              //返回最后一个元素
        return rear.value;
    }

    public int front(){             //返回首元素
        return front.value;
    }

    public int size(){              // 返回容量
        return size;
    }

    public boolean isEmpty(){       //判空
        return size == 0;
    }
}
