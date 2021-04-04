package leetcode;

import java.util.Stack;

public class LT151_MinStack<T extends Comparable > {
    private Stack<T> innerStack;
    private Stack<T> innerMinStack;

    public LT151_MinStack(){
        innerStack=new Stack<>();
        innerMinStack =new Stack<>();
    }

    public T pop(){
        innerMinStack.pop();
        return innerStack.pop();
    }

    public T peek(){
        return innerStack.peek();
    }

    public void push(T t){
        if(innerStack.isEmpty()){
            innerStack.push(t);
            innerMinStack.push(t);
        }else{
            if(t.compareTo(innerMinStack.peek())>0){
                innerMinStack.push(innerMinStack.peek());
                innerStack.push(t);
            }else{
                innerMinStack.push(t);
                innerStack.push(t);
            }
        }
    }
    public T getMin(){
        return innerMinStack.peek();
    }

    public boolean isEmpty(){
        return innerStack.isEmpty();
    }
    public static void main(String[] args){
        LT151_MinStack<Integer> minStack = new LT151_MinStack();
        minStack.push(1);
        minStack.push(5);
        minStack.push(0);
        minStack.push(5);
        minStack.push(-1);
        while(!minStack.isEmpty()){
            System.out.print(minStack.getMin());
            System.out.print("--");
            System.out.println(minStack.pop());
        }
    }
}
