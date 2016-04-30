package Trees;

import java.util.LinkedList;
import java.util.Queue;

public class DeepestLeftLeaf {

	public static TreeNode findLeftDeepLeaf(TreeNode root) {
		if (root == null)
			return null;

		TreeNode current = null;
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.offer(root);
		int level = 0;
		int resultLevel = 0;
		TreeNode result = null;
		while (!queue.isEmpty()) {
			level++;
			int len = queue.size();
			while (len != 0) {
				current = queue.poll();
				if (current == null) {
					len--;
					continue;
				}
				TreeNode left = current.left;
				TreeNode right = current.right;
				if (level > resultLevel && left != null) {
					System.out.println(left.val);
					result = left;
					resultLevel = level;
				}
				queue.add(left);
				queue.add(right);
				len--;
			}
		}
		return result;
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		root.right.left = new TreeNode(6);
		root.right.right = new TreeNode(7);
		root.right.right.right = new TreeNode(8);
//		root.right.left = new TreeNode(5);
//		root.right.right = new TreeNode(6);
//		root.right.left.right = new TreeNode(7);
//		root.right.right.right = new TreeNode(8);
//		root.right.left.right.left = new TreeNode(9);
//		root.right.right.right.right = new TreeNode(10);
		TreeNode result = findLeftDeepLeaf(root);
		System.out.println(result.val);
	}
}
