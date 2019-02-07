package zuochengyun.Ch01StackAndQueue.P03ReverseStack;

import java.util.Stack;

/**
 * 由ReverseStack联想到的：
 *
 * 仅用一个栈构建队列
 */
public class OneStackQueue {
    private Stack<Integer> stack;

    public OneStackQueue() {
        this.stack = new Stack<>();
    }

    private int getAndRemoveLastElement(Stack<Integer> stack) {
        int result = stack.pop();
        if (stack.isEmpty()) {
            return result;
        } else {
            int last = getAndRemoveLastElement(stack);
            stack.push(result);
            return last;
        }
    }


    private int getLastElement(Stack<Integer> stack) {
        int result = stack.pop();
        if (stack.isEmpty()) {
            stack.push(result);
            return result;
        } else {
            int last = getLastElement(stack);
            stack.push(result);
            return last;
        }
    }

    public void add(int ele) {
        stack.push(ele);
    }

    public int poll() {
        return getAndRemoveLastElement(stack);
    }

    public int peek() {
        return getLastElement(stack);

    }

    public static void main(String[] args) {
        OneStackQueue queue = new OneStackQueue();
        queue.add(1);
        queue.add(2);
        queue.add(3);

        System.out.println(queue.peek());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
    }
}
