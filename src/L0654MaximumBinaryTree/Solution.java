package L0654MaximumBinaryTree;

import java.util.LinkedList;

/**
 * 时间复杂度为O(N)
 */
public class Solution {

    public TreeNode constructMaximumBinaryTree(int[] nums) {

        LinkedList<TreeNode> stack = new LinkedList<>();
        TreeNode root = new TreeNode(nums[0]);
        TreeNode prev = root;
        stack.push(prev);

        for (int i = 1; i < nums.length; i++) {
            TreeNode curNode = new TreeNode(nums[i]);
            if (curNode.val > root.val) {
                root = curNode;
            }
            // 当前元素比stack栈顶的大
            if (curNode.val > stack.peek().val) {
                // prev记录最后一个被pop出来的
                while (!stack.isEmpty() && curNode.val > stack.peek().val) {
                    prev = stack.pop();
                }
                // stack 为空，说明curNode为当前最大的，将其left指向prev即可
                if (stack.isEmpty()) {
                    curNode.left = prev;
                } else { // 否则，将curNode插入到stack.peek()和prev中间
                    stack.peek().right = curNode;
                    curNode.left = prev;
                }
            }
            // 当前元素比stack栈顶小
            else {
                stack.peek().right = curNode;
            }
            stack.push(curNode);
        }

        return root;

    }

    public class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;
        public TreeNode(int data) {
            this.val = data;
        }
    }
}
