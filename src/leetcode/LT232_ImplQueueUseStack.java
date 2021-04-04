package leetcode;

import java.util.Stack;

public class LT232_ImplQueueUseStack<T> {
    private Stack<T> innerStack;
    public LT232_ImplQueueUseStack(){
        innerStack=new Stack<>();
    }
    public T pop(){
        return innerStack.pop();
    }

    public T peek(){
        return innerStack.peek();
    }

    public void push(T t){
        Stack<T> tmp= new Stack<>();
        while(!innerStack.isEmpty()){
            tmp.push(innerStack.pop());
        }
        innerStack.push(t);
        while(!tmp.isEmpty()){
            innerStack.push(tmp.pop());
        }

    }
    public static void main(String[] args){
        LT232_ImplQueueUseStack<String> queue = new LT232_ImplQueueUseStack<>();
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
