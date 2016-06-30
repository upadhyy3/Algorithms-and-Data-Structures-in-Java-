package DynamicProgramming;

import java.util.*;

public class cutTree {

	public int numberOfCuts(int nodes, int k, int[][] mat) {
		Set<Integer> T = new HashSet<Integer>();
		int result = 0;
		for(int len=1;len<=nodes;len++){
			for(int j=1;j<=nodes-len+1;j++){
				int current = j;
				T.clear();
				while(current<j+len){
					T.add(current);
					current++;
				}
				if(isValid(T, mat, nodes, k)){
					result++;
				}
			}
		}
		return result+1;
	}

	public boolean isValid(Set<Integer> T,int[][] mat,
			int n, int k) {
		boolean[] visited = new boolean[n + 1];
		// first check whether tree is a subtree BFS
		int numberOfEdges = 0;
		for (int current : T) {
			for (int j = 0; j < mat.length; j++) {
				if (mat[current - 1][j] == 1) {
					visited[current] = true;
					if (!T.contains(j + 1)) {
						numberOfEdges++;
					}
				}
			}
		}

		if (numberOfEdges > k) {
			return false;
		}

		for (int current : T) {
			if (!visited[current])
				return false;
		}

		return true;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[][] adj = { { 0, 1, 0 ,0}, { 1, 0, 1,0 }, { 0, 1, 0,1 },{0,0,1,0} 
			};
		int nodes =4;
		int k=1;
		cutTree ct = new cutTree();
		System.out.println(ct.numberOfCuts(nodes, k, adj));

	}

}
