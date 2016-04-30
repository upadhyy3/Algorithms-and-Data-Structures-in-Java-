package Trees;


public class TreeIntoTwoHalves {
	
	/*
	 *             5
	 *        1				2
	 *      0   4		3  
	 *      output : true
	 */

	public static boolean isSeperable(TreeNode root){
		int size = sizeOfTree(root);
		if(helper(root.left, size) || helper(root.right, size))return true;
		else return false;
	}
	
	public static boolean helper(TreeNode root , int size){
		if(root == null) return false;
		int currentSize = sizeOfTree(root);
		if(size - currentSize == currentSize) return true;
		if(helper(root.left, size) || helper(root.right, size))return true;
		else return false;
	}
	
	public static int sizeOfTree(TreeNode root){
		if(root == null) return 0;
		return sizeOfTree(root.left) + 1 +sizeOfTree(root.right);
	}
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(5);
		root.left = new TreeNode(1);
		root.right = new TreeNode(2);
		root.left.left = new TreeNode(0);
		root.left.right = new TreeNode(4);
		root.right.left = new TreeNode(3);
		root.right.right = new TreeNode(7);
		System.out.println(isSeperable(root));
	}
}
