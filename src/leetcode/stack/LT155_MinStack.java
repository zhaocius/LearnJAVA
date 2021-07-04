package leetcode.stack;

import java.util.Stack;

public class LT155_MinStack {
    Stack<Integer> data;
    Stack<Integer> minstack;
    /** initialize your data structure here. */
    LT155_MinStack() {
        data = new Stack<>();
        minstack = new Stack<>();

    }

    void push(int x) {
        data.push(x);
        if(minstack.empty() || x <= minstack.peek()){
            minstack.push(x);
        }
    }

    void pop() {
        if(data.peek() == minstack.peek()){
            minstack.pop();
        }
        data.pop();
    }

    int top() {
        return data.peek();
    }

    int getMin() {
        return minstack.peek();
    }

    public static void main(String[] args){
        LT155_MinStack minStack = new LT155_MinStack();
        minStack.push(2);
        minStack.push(3);
        minStack.push(4);
        minStack.push(5);
        minStack.push(1);
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.getMin());

    }
}
