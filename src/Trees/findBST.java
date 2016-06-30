package Trees;

public class findBST {

	// public int findMaxBST(TreeNode root){
	// int max = Integer.MIN_VALUE;
	//
	// }

	public int size(TreeNode root) {
		if (root == null)
			return 0;

		return (size(root.left) + 1 + size(root.right));
	}

	public int findMaxBST(TreeNode current) {
		if(isBST(current)){
			return size(current);
		}
		else{
			return Math.max(findMaxBST(current.left), findMaxBST(current.right));
		}
	}

	public boolean isBST(TreeNode root) {
		if (root == null)
			return true;

		if (!isBST(root.left) || !isBST(root.right)
				|| (root.left != null && root.left.val > root.val)
				|| (root.right != null && root.right.val < root.val)) {
			return false;
		}
		return true;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root = new TreeNode(5);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(1);
		root.left.right = new TreeNode(3);
		root.right.left = new TreeNode(6);
		// root.right.right = new TreeNode(7);
		// root.right.right.right = new TreeNode(8);

		findBST fb = new findBST();
		System.out.println(fb.findMaxBST(root));

	}

}
