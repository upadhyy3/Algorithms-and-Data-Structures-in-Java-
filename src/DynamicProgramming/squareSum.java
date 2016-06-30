package DynamicProgramming;

import java.util.*;
public class squareSum {

	public static int minSize = Integer.MAX_VALUE;
	public static int minNumbers(int number){
		int squareRoot = (int)Math.sqrt(number);
		for(int i= squareRoot ;i>=1;i--){
			recursion(i,0,number,new ArrayList<Integer>());
		}
		return minSize;
	}
	
	public static void recursion(int currentNumber,int currentSum,int number,ArrayList<Integer> temp){
		if(currentSum == number){
			int currentSize = temp.size();
			System.out.println(temp.toString());
			if(currentSize < minSize){
				minSize = currentSize;
			}
		}
		else if(currentSum > number){
			return;
		}
		
		for(int i= currentNumber ;i>=1;i--){
			temp.add(i);
			recursion(currentNumber, currentSum + i*i, number, temp);
			temp.remove(temp.size()-1);
		}
		
	}
	
	public static int minNumberDP(int number){
		int squareRoot = (int)Math.sqrt(number);
		int[][] DP = new int[squareRoot+1][number+1];
//		DP[0][0] = 1;
//		for(int i=0;i<=squareRoot;i++){
//			DP[0][i] = 1;
//		}
		int include =0;
		int exclude = 0;
		for(int i=1;i<=squareRoot;i++){
			for(int j=1;j<=number;j++){
//				include = Integer.MAX_VALUE;
//				exclude = Integer.MAX_VALUE;
				// include
				if(j - i*i >= 0){
					include = DP[i][j-i*i] + 1;
				}
				else{
					include = Integer.MAX_VALUE;
				}
					
				// exclude
				if(i>0 && DP[i-1][j]!=0){
					exclude = DP[i-1][j];
				}
				else{
					exclude = Integer.MAX_VALUE;
				}
				
				DP[i][j] = Math.min(include, exclude);
			}
		}
		System.out.println(Arrays.deepToString(DP));
		return DP[squareRoot][number];
	}
	
	public static void main(String[] args) {
		System.out.println(minNumbers(12));
		System.out.println(minNumberDP(12));
	}
}
