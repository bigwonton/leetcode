package zuochengyun.Ch01StackAndQueue.P01GetMin;

import java.util.Stack;

public class MyStack2 {
    private Stack<Integer> stackData;
    private Stack<Integer> stackMin;

    public MyStack2() {
        stackData = new Stack<>();
        stackMin = new Stack<>();
    }

    public void push(int ele) {
        stackData.push(ele);
        if (!stackMin.isEmpty()) {
            int min = stackMin.peek();
            if (ele <= min) {
                stackMin.push(ele);
            } else {
                stackMin.push(min);
            }
        } else {
            stackMin.push(ele);
        }
    }

    public int pop() {
        if (stackData.isEmpty()) {
            throw new RuntimeException("Stack is empty.");
        }
        stackMin.pop();
        return stackData.pop();
    }

    public int getMin() {
        if (stackMin.isEmpty()) {
            throw new RuntimeException("Stack is empty.");
        }
        return stackMin.peek();
    }

    public static void main(String[] args) {
        MyStack2 myStack1 = new MyStack2();
        myStack1.push(3);
        myStack1.push(4);
        myStack1.push(5);
        myStack1.push(1);
        myStack1.push(2);
        myStack1.push(1);


        System.out.println(myStack1.getMin());
        myStack1.pop();
        System.out.println(myStack1.getMin());
        myStack1.pop();
        System.out.println(myStack1.getMin());
        myStack1.pop();
        System.out.println(myStack1.getMin());
        myStack1.pop();
        System.out.println(myStack1.getMin());
        myStack1.pop();
        System.out.println(myStack1.getMin());
        myStack1.pop();


    }

}
