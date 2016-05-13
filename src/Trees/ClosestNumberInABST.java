package Trees;

public class ClosestNumberInABST {
	

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		root.right.left = new TreeNode(6);
		root.right.right = new TreeNode(7);
		root.right.right.right = new TreeNode(8);
		root.right.left = new TreeNode(5);
		root.right.right = new TreeNode(6);
		root.right.left.right = new TreeNode(7);
		root.right.right.right = new TreeNode(8);
		root.right.left.right.left = new TreeNode(9);
		root.right.right.right.right = new TreeNode(10);
	}
}
