package DynamicProgramming;

import java.util.LinkedList;
import java.util.List;

public class UniqueBinarySearchTree {

	int left = 0;
	int[] DP;

	public int numTrees(int n) {
		DP = new int[n];
		int number = recursion(n, DP);
		return number;
	}

	public int recursion(int n, int[] DP) {
		if (n == 0 || n == 1)
			return 1;
		int number = 0;
		int left = 1;
		int right = 1;
		for (int i = 1; i <= n; i++) {

			if (DP[i - 1] != 0)
				left = DP[i - 1];
			else {
				left = recursion(i - 1, DP);
				DP[i - 1] = left;
			}

			if (DP[n - i] != 0)
				right = DP[n - i];
			else {
				right = recursion(n - i, DP);
				DP[n - i] = right;
			}
			number += left * right;
		}

		return number;
	}

	
	//generate unique trees
	
	public List<TreeNode> generateTrees(int n) {
		if (n == 0)
			return new LinkedList<TreeNode>();
		return generateTrees(1, n);
		// return result;
	}

	public List<TreeNode> generateTrees(int start, int end) {
		List<TreeNode> list = new LinkedList<TreeNode>();
		if (start > end) {
			list.add(null);
			return list;
		}

		for (int i = start; i <= end; i++) {
			List<TreeNode> leftNodes = generateTrees(start, i - 1);
			List<TreeNode> rightNodes = generateTrees(i + 1, end);
			for (TreeNode left : leftNodes) {
				for (TreeNode right : rightNodes) {
					TreeNode root = new TreeNode(i);
					root.left = left;
					root.right = right;
					list.add(root);
				}
			}

		}

		return list;
	}
}
