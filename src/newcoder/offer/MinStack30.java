package newcoder.offer;

import java.util.Stack;

public class MinStack30 {
    private Stack<Integer> dataStack = new Stack<>();
    private Stack<Integer> minStack = new Stack<>();
    public void push(int node) {
        dataStack.push(node);
        if (!minStack.isEmpty()){
            int temp = minStack.peek();
            if (temp > node){
                minStack.push(node);
            }
            else {
                minStack.push(temp);
            }
        }else {
            minStack.push(node);
        }

    }

    public void pop() {
        dataStack.pop();
        minStack.pop();

    }

    public int top() {
        return dataStack.peek();

    }

    public int min() {
       return minStack.peek();

    }

}
