package leetcode.stack;

import java.util.Stack;

public class LT232_ImplQueueUseTwoStacks<T> {
    private Stack<T> in;
    private Stack<T> out;

    public LT232_ImplQueueUseTwoStacks(){
        in=new Stack<>();
        out = new Stack<>();
    }
    public T pop(){
        inToOut();
        return out.pop();
    }

    public T peek(){
        inToOut();
        return out.peek();
    }

    private void inToOut(){  //如果out里有数据，就不需要移动，省时间。
        if(out.isEmpty()){
            while(!in.isEmpty())
                out.push(in.pop());
        }
    }

    public void push(T t){
        in.push(t);
    }
    public static void main(String[] args){
        LT232_ImplQueueUseTwoStacks<String> queue = new LT232_ImplQueueUseTwoStacks<>();
        queue.push("1");
        System.out.println(queue.pop());
        queue.push("2");
        queue.push("3");
        queue.push("4");
        queue.push("5");
        System.out.println(queue.pop());
        System.out.println(queue.pop());
        System.out.println(queue.pop());
        System.out.println(queue.pop());

    }
}
