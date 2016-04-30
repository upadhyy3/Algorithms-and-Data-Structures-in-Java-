package Trees;

public class sizeOfATree {

	public static int sizeOfTree(TreeNode root){
		if(root == null) return 0;
		return sizeOfTree(root.left) + 1 +sizeOfTree(root.right);
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
		System.out.println(sizeOfTree(root));
	}
	
}
