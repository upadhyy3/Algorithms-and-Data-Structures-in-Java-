package Trees;

import java.util.*;

public class recoverTree {

//	public void recoverTree(TreeNode root) {
//		if (root == null)
//			return;
//		else if (root.right == null && root.left == null)
//			return;
//		TreeNode current = root;
//		if (current.right == null) {
//			if (current.val < current.left.val) {
//				swap(current,current.left);
////				return;
//			}
//			else{
//				recoverTree(current.left);
//			}
//		}
//		else if(current.left == null){
//			if (current.val > current.right.val) {
//				swap(current,current.right);
////				return;
//			}
//			else{
//				recoverTree(current.right);
//			}
//		}
//		else{
//			//Both child nodes are swapped
//			if(current.val <current.left.val && current.val > current.right.val){
//				swap(current.left,current.right);
//			}
//			else if(current.val <current.left.val){
//				swap(current,current.left);
//			}
//			else if(current.val > current.right.val){
//				swap(current,current.right);
//			}
//			else{
//				recoverTree(current.left);
//				recoverTree(current.right);
//			}
//		}
//
//	}

	public void recoverTree(TreeNode root){
		ArrayList<TreeNode> flatTree = flattenTree(root);
		TreeNode misPlacedNodeOne = flatTree.get(0);
		TreeNode misPlacedNodeTwo = null;
		for(int i=1;i<flatTree.size();i++){
			if(misPlacedNodeOne.val > flatTree.get(i).val){
				while(i<flatTree.size() && misPlacedNodeOne.val > flatTree.get(i).val){
					misPlacedNodeTwo = flatTree.get(i);
					i++;
				}
				swap(misPlacedNodeOne, misPlacedNodeTwo);
				return;
			}
			misPlacedNodeOne = flatTree.get(i);
		}
	}
	
	public ArrayList<TreeNode> flattenTree(TreeNode root){
		ArrayList<TreeNode> flatTree = new ArrayList<TreeNode>();
		Stack<TreeNode> stack = new Stack<TreeNode>();
		TreeNode current = root;
		do{
			if(current != null){
				stack.push(current);
				current = current.left;
			}
			else{
				TreeNode temp = stack.pop();
				flatTree.add(temp);
				System.out.println(temp.val);
				if(temp.right!=null && stack.isEmpty()){
					stack.push(temp.right);
					current = temp.right.left;
				}
				else if(temp.right!=null){
					current = temp.right;;
				}
				else{
					current = null;
				}
			}
		}while(!stack.isEmpty());
		return flatTree;
	}
	public void swap(TreeNode one, TreeNode two) {
		int temp = one.val;
		one.val = two.val;
		two.val = temp;
	}

	public static void preOrderBetterApproach(TreeNode root) {

		if (root == null)
			return;

		Stack<TreeNode> stack = new Stack<TreeNode>();
		stack.push(root);
		System.out.print("[");
		while (!stack.empty()) {
			TreeNode n = stack.pop();

			if (n.right != null) {
				stack.push(n.right);
			}
			if (n.left != null) {
				stack.push(n.left);
			}

		}

	}

	public String serialize(TreeNode root) {
		if (root == null)
			return "";
		StringBuilder sb = new StringBuilder();
		buildString(root, sb);
		// System.out.println(sb.toString());
		return sb.toString();
	}

	public void buildString(TreeNode root, StringBuilder sb) {
		if (root == null) {
			sb.append("null,");
		} else {
			sb.append(root.val).append(",");
			buildString(root.left, sb);
			buildString(root.right, sb);
		}
	}

	public static void levelOrder(TreeNode root) {
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		TreeNode current = root;
		queue.add(root);
		System.out.print("[");
		do {
			current = queue.poll();
			if (current == null) {
				// System.out.print("null");
				continue;
			} else {
				System.out.print(current.val);
			}
			if (current.left != null)
				queue.add(current.left);
			// else System.out.print("null");
			if (current.right != null)
				queue.add(current.right);
			// else System.out.print("null");
			if (!queue.isEmpty())
				System.out.print(",");
		} while (!queue.isEmpty());
		System.out.print("]");
	}

	public static void preOrder(TreeNode root) {
		Stack<TreeNode> stack = new Stack<TreeNode>();
		TreeNode current = root;
		TreeNode temp = null;
		do {
			if (current != null) {
				if (current.right != null) {
					stack.push(current.right);
				}
				System.out.println(current.val);
				current = current.left;
			} else {
				temp = stack.pop();
				System.out.println(temp.val);
				current = temp.left;
				if (stack.isEmpty() && temp.right != null) {
					stack.push(temp.right);
				}
			}
		} while (!stack.isEmpty());
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(5);
		root.left = new TreeNode(1);
		root.right = new TreeNode(4);
		root.right.right = new TreeNode(3);
//		root.left.left = new TreeNode(3);
//		root.left.right = new TreeNode(1);
//		root.right.left = new TreeNode(6);
//		root.right.right = new TreeNode(9);
		// root.right.right.right = new TreeNode(10);
		recoverTree rt = new recoverTree();
		System.out.println(rt.serialize(root));
		rt.recoverTree(root);
		System.out.println(rt.serialize(root));
	}
}
