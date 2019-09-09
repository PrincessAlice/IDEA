import java.util.LinkedList;
import java.util.Queue;

//用队列实现栈
public class MyStackWithQueue {
    private Queue<Integer> queue = new LinkedList<>();

    public void push(int x){    //将元素放到栈顶(入栈)
        queue.add(x);
    }

    public int pop(int x){      //删除栈顶元素，并返回该元素的值（出栈）
        int size = queue.size();
        for(int i=0;i<size -1;i++){
            int v = queue.poll();    //删除队列的头元素，若队列为空，返回null
            queue.add(v);               //在队列中插入元素
        }
       /*
        int v=queue.poll();
        queue.add(v);
        return v;
        */
        return queue.poll();
    }

    public boolean empty(){         //判断堆栈是否为空
        return queue.isEmpty();
    }
}
