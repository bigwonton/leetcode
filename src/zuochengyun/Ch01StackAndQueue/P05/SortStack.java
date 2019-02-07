package zuochengyun.Ch01StackAndQueue.P05;

import java.util.Stack;

/**
 * 用一个栈实现另一个栈的排®序
 */
public class SortStack {
    public static void sortStackByStack(Stack<Integer> stack) {
        Stack<Integer> help = new Stack<>();
        while (!stack.isEmpty()) {
            int cur = stack.pop();
            if (help.isEmpty()) {
                help.push(cur);
            } else {
                while (!help.isEmpty() && cur > help.peek()) {
                    stack.push(help.pop());
                }
                help.push(cur);
            }
        }

        while(!help.isEmpty()) {
            stack.push(help.pop());
        }
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(3);
        stack.push(4);
        stack.push(2);

        System.out.println(stack);
        sortStackByStack(stack);
        System.out.println(stack);
    }
}
