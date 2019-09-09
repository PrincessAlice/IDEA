import java.util.Arrays;
//用顺序表实现栈

public class MyStack {
    private int[] array = new int[10];
    private int top = 0;
    private void ensureCapacity(){
        if(top<array.length){
            return;
        }

        array = Arrays.copyOf(array,2*array.length);
    }

    public int push(int element){       //查找栈顶元素并输出
        ensureCapacity();
        array[top++] = element;
        return element;
    }

    public int pop(){               //删除栈顶元素并返回该元素的值

        return array[--top];
    }

    public int peek(){          //查找栈顶元素，不删除

        return array[top-1];
    }

    public boolean empty(){      // 判断栈是否为空

        return top == 0;
    }

    public int size(){             //返回栈的容量

        return top;
    }

    public int search(int element){     //查找element 元素在栈内的位置，并返回下标
        for(int i =0 ;i<top;i++){
            if(array[i] == element){
                return i;
            }
        }
        return -1;
    }



}
