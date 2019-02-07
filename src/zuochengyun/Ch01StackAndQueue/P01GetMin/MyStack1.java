package zuochengyun.Ch01StackAndQueue.P01GetMin;

import java.util.Stack;

/**
 * 设计一个有getMin功能的栈
 *
 * push的时候检查元素与stackMin栈顶元素的大小
 * pop的时候也要检查，如果是最小元素被出栈，那么stackMin也要相应pop
 */
public class MyStack1 {
    private Stack<Integer> stackData;
    private Stack<Integer> stackMin;

    public MyStack1() {
        stackData = new Stack<Integer>();
        stackMin = new Stack<Integer>();
    }

    public void push(int ele) {
        if (stackMin.isEmpty()) {
            stackMin.push(ele);
        } else {
            int min = stackMin.peek();
            if (ele <= min) {
                stackMin.push(ele);
            }
        }
        stackData.push(ele);
    }

    public int pop() {
        if (stackData.isEmpty()) {
            throw new RuntimeException("Stack is empty.");
        }
        int result = stackData.pop();
        if (result == stackMin.peek()) {
            stackMin.pop();
        }
        return result;
    }

    public int getMin() {
        if (stackMin.isEmpty()) {
            throw new RuntimeException("Stack is empty.");
        }
        return stackMin.peek();
    }

    public static void main(String[] args) {
        MyStack1 myStack1 = new MyStack1();
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
