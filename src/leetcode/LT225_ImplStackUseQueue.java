package leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class LT225_ImplStackUseQueue<T> {
    private Queue<T> innerQueue;
    public LT225_ImplStackUseQueue(){
        innerQueue=new LinkedList<>();
    }
    public T pop(){
        return innerQueue.remove();
    }

    public T peek(){
        return innerQueue.peek();
    }

    public void push(T t){
        innerQueue.add(t);
        for(int i = 1;i<innerQueue.size();i++){  //每次有新的压占，内部循环n-1次，保证最新的转到栈顶。
            innerQueue.add(innerQueue.remove());
        }
    }
    public static void main(String[] args){
        LT225_ImplStackUseQueue<String> queue = new LT225_ImplStackUseQueue<>();
        queue.push("1");
        queue.push("2");
        queue.push("3");
        queue.push("4");
        queue.push("5");

        System.out.println(queue.pop());
        System.out.println(queue.pop());
        System.out.println(queue.pop());
        System.out.println(queue.pop());
        System.out.println(queue.pop());

    }
}
