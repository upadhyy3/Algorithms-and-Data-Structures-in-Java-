package Trees;

import java.util.*;
public class fidLeavesOfTree {

	
	public List<List<Integer>> findLeaves(TreeNode root){
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		DFS(root,result);
		return result;
	}
	
	public int DFS(TreeNode root,List<List<Integer>> res){
		if(root == null){
			return 0;
		}
		
		int levelCount = Math.max(DFS(root.left,res), DFS(root.right,res));
		while(res.size()<= levelCount){
			List<Integer> list = new ArrayList<Integer>();
			res.add(list);
		}
		
		res.get(levelCount).add(root.val);
		return levelCount+1;
	}
	
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
//		root.right.left = new TreeNode(6);
//		root.right.right = new TreeNode(7);
//		root.right.right.right = new TreeNode(8);
		fidLeavesOfTree fl = new fidLeavesOfTree();
		System.out.println(fl.findLeaves(root));
	}

}
