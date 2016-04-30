package Trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class PBTSpecificLevelOrderTraversal {

	/*
	 * Given 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 output: 8 15 9 14 10 13 11 12 4
	 * 7 5 6 2 3 1
	 */
	public static void specificLevelOrder(TreeNode root) {
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		Stack<Integer> stack = new Stack<Integer>();
		stack.push(root.val);
		queue.add(root.left);
		queue.add(root.right);
		TreeNode left = null;
		TreeNode right = null;
		while (!queue.isEmpty()) {
			left = queue.poll();
			right = queue.poll();
			if (left == null || right == null)
				break;
			stack.push(right.val);
			stack.push(left.val);

			queue.add(left.right);
			queue.add(right.left);
			queue.add(left.left);
			queue.add(right.right);

		}

		while (!stack.isEmpty()) {
			System.out.println(stack.pop());
		}
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		root.right.left = new TreeNode(6);
		root.right.right = new TreeNode(7);
		root.left.left.left = new TreeNode(8);
		root.left.left.right = new TreeNode(9);
		root.left.right.left = new TreeNode(10);
		root.left.right.right = new TreeNode(11);
		root.right.left.left = new TreeNode(12);
		root.right.left.right = new TreeNode(13);
		root.right.right.left = new TreeNode(14);
		root.right.right.right = new TreeNode(15);
		specificLevelOrder(root);
	}
}
