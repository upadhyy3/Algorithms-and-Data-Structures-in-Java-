package uber;

import java.util.Arrays;

public class longestCommonSubsequence {

	public static int lcs(String first,String second){
		int[][] result = new int[first.length()+1][second.length()+1];
		for(int i=0;i<=first.length();i++){
			for(int j=0;j<=second.length();j++){
				if(i==0 || j==0) result[i][j] = 0;
				else if(first.charAt(i-1) == second.charAt(j-1)) result[i][j] = 1 + result[i-1][j-1];
				else result[i][j] = Math.max(result[i-1][j], result[i][j-1]);
			}
		}
		System.out.println(Arrays.deepToString(result));
		return result[first.length()][second.length()];
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String first = "ShivamUpadhyay";
		String second = "ahivs";
		System.out.println(lcs(first,second));
	}

}
