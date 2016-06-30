package Trees;

public class uniValue {

	public int size(TreeNode root) {
		if (root == null)
			return 0;

		return (size(root.left) + 1 + size(root.right));
	}

	int count = 0;

	public int countUnivalSubtrees(TreeNode root) {
		if (root == null)
			return 0;

		isUniVal(root);
		return count;
	}

	public boolean isUniVal(TreeNode root) {
		if (root == null)
			return true;

		boolean left = isUniVal(root.left);
		boolean right = isUniVal(root.right);

		if (left && right && (root.left == null || root.left.val == root.val)
				&& (root.right == null || root.right.val == root.val)) {
			count++;
			return true;
		}
		
		return false;
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(5);
		root.left = new TreeNode(1);
		root.right = new TreeNode(5);
		root.left.left = new TreeNode(5);
		root.left.right = new TreeNode(5);
		root.right.right = new TreeNode(5);
		// root.right.right = new TreeNode(7);
		// root.right.right.right = new TreeNode(8);
		uniValue uv = new uniValue();
		System.out.println(uv.countUnivalSubtrees(root));
	}
}
