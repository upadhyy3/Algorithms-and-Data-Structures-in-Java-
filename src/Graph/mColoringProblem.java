package Graph;
import java.util.*;
public class mColoringProblem {
	public int[] colorGraph(int[][] graph,int m){
		int[] result = new int[graph.length];
		
		fillColor(0, result, m, graph);
		return result;
	}
	
	public void fillColor(int k,int[] result,int m,int[][] graph){
		for(int i=1;i<=m;i++){
			if(isValid(graph, k, result, i)){
				result[k] = i;
				if(k+1<result.length)
				fillColor(k+1, result, m, graph);
				else
				return;
			}
		}
	}
	
	public boolean isValid(int[][] graph,int nodeId,int[] result,int colorAssigned){
		for(int i=0;i<graph[0].length;i++){
			if(graph[nodeId][i] ==1 && result[i] == colorAssigned){
				return false;
			}
		}
		return true;
	}
	
	public static void main(String[] args) {
		int[][] graph = {{0, 1, 1, 1},
	            {1, 0, 1, 0},
	            {1, 1, 0, 1},
	            {1, 0, 1, 0},
	        };
		int m = 3;
		mColoringProblem cp = new mColoringProblem();
		System.out.println(Arrays.toString(cp.colorGraph(graph, m)));
		
	}
}
