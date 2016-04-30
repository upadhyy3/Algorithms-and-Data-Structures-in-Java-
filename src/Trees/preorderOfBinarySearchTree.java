package Trees;

import java.util.Stack;

public class preorderOfBinarySearchTree {

	public static boolean isFeasibleBST(int[] pre){
		return true;
	}
	
	public static boolean recursion(int[] pre, int start,int end){
		if(start>end) return true;
		int root = pre[start];
		int i = start+1;
		for(;i<=end;i++){
			if(pre[i] > root){
				
			}
		}
		return true;
	}
	public static void main(String[] args){
		int[] arr = {2,4,3};
		System.out.println(isFeasibleBST(arr));
	}
}
