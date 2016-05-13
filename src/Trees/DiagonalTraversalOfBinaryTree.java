package Trees;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class DiagonalTraversalOfBinaryTree {
	public static void printDiagonal(TreeNode root) {
		if (root == null)
			return;
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.offer(root);
		TreeNode current = null;
		int size = 0;
		do {
			size = queue.size();
			while (size > 0) {
				current = queue.poll();
				while (current != null) {
					System.out.print(current.val + ",");
					if (current.left != null) {
						queue.offer(current.left);
					}
					current = current.right;
				}
				size--;
			}
			System.out.println("");
		} while (!queue.isEmpty());
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(8);
		root.left = new TreeNode(3);
		root.right = new TreeNode(10);
		root.left.left = new TreeNode(1);
		root.left.right = new TreeNode(6);
		root.right.right = new TreeNode(14);
		root.right.right.left = new TreeNode(13);
		root.left.right.right = new TreeNode(7);
		root.left.right.left = new TreeNode(4);
		printDiagonal(root);
		System.out.println();
	}
}
