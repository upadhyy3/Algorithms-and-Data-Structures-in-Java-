package Trees;

import java.util.ArrayList;
import java.util.Arrays;

public class AncestorMatrix {

	/*
	 * mat[i][j] = 1 if i is ancestor of j
	 * mat[i][j] = 0, otherwise
	 */
	static int matSize;
	static int[][] matrix;
	public static int[][] ancestorMatrix(TreeNode root) {
		matSize = root.val;
		matrix = new int[matSize+1][matSize+1];
		ArrayList<Integer> currentAncestors = new ArrayList<Integer>();
		currentAncestors.add(root.val);
		recursion(root.left,currentAncestors);
		recursion(root.right,currentAncestors);
		
		return matrix;
	}
	
	public static void recursion(TreeNode root,ArrayList<Integer> currentAncestors){
		if(root == null) return;
		int j = root.val;
		for(Integer i:currentAncestors){
			matrix[i][j] = 1;
		}
		currentAncestors.add(root.val);
		recursion(root.left,currentAncestors);
		recursion(root.right,currentAncestors);
		currentAncestors.remove(currentAncestors.size()-1);
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(5);
		root.left = new TreeNode(1);
		root.right = new TreeNode(2);
		root.left.left = new TreeNode(0);
		root.left.right = new TreeNode(4);
		root.right.left = new TreeNode(3);
		
		int[][] matrix = ancestorMatrix(root);
		System.out.println(Arrays.deepToString(matrix));

	}
}
