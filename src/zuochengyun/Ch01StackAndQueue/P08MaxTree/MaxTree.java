package zuochengyun.Ch01StackAndQueue.P08MaxTree;

import java.util.HashMap;
import java.util.Stack;

/**
 * 构造数组的MaxTree
 * 要求
 *      时间复杂度为O(N)
 *      额外空间复杂度为O(N)
 */
public class MaxTree {

    public Node getMaxTree(int[] arr) {
        // 先把arr转成Node数组
        Node[] nodeArr = new Node[arr.length];
        for (int i = 0; i < arr.length; i++) {
            nodeArr[i] = new Node(arr[i]);
        }

        // 创建两个map，分别存放左边/右边第一个比curNode大的Node
        HashMap<Node, Node> lBigMap = new HashMap<>();
        HashMap<Node, Node> rBigMap = new HashMap<>();
        // 创建Stack，工具，来计算lBigMap和rBigMap
        Stack<Node> stack = new Stack<>();

        //计算lBigMap
        for (int i = 0; i < nodeArr.length; i++) {
            Node curNode = nodeArr[i];
            while (!stack.isEmpty() && stack.peek().value < curNode.value) {
                popStackAndSetMap(stack, lBigMap);
            }
            stack.push(curNode);
        }
        // 将stack里的元素全部弹出，完善lBigMap
        while (!stack.isEmpty()) {
            popStackAndSetMap(stack, lBigMap);
        }

        // 计算rBigMap
        for (int i = nodeArr.length - 1; i >= 0; i--) {
            Node curNode = nodeArr[i];
            while (!stack.isEmpty() && stack.peek().value < curNode.value) {
                popStackAndSetMap(stack, rBigMap);
            }
            stack.push(curNode);
        }
        // 将stack里的元素全部弹出，完善rBigMap
        while (!stack.isEmpty()) {
            popStackAndSetMap(stack, rBigMap);
        }

        // 完善maxTree
        Node head = null;
        for (int i = 0; i < nodeArr.length; i ++) {
            Node curNode = nodeArr[i];
            Node left = lBigMap.get(curNode);
            Node right = rBigMap.get(curNode);

            if (left == null && right == null) {
                head = curNode;
            } else if (left == null) {
                if (right.left == null) {
                    right.left = curNode;
                } else {
                    right.right = curNode;
                }
            } else if (right == null) {
                if (left.left == null) {
                    left.left = curNode;
                } else {
                    left.right = curNode;
                }
            } else {
                Node parent = (left.value > right.value) ? right : left;
                if (parent.left == null) {
                    parent.left = curNode;
                } else {
                    parent.right = curNode;
                }
            }
        }

        return head;

    }

    private void popStackAndSetMap(Stack<Node> stack, HashMap<Node, Node> map) {
        Node popNode = stack.pop();
        if (stack.isEmpty()) {
            map.put(popNode, null);
        } else {
            map.put(popNode, stack.peek());
        }
    }


    public class Node {
        public int value;
        public Node left;
        public Node right;
        public Node(int data) {
            this.value = data;
        }
    }
}
