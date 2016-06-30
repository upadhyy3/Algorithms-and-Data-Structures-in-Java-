package DynamicProgramming;
import java.util.*;
public class ropeLength {

	public static int maxProduct = Integer.MIN_VALUE;
	public static int maxProductRopes(int n){
		if(n==0 || n==1) return 0;
		int[] DP = new int[n+1];
		DP[1] = 1;;
		for(int i=2;i<=n;i++){
			int mp = Integer.MIN_VALUE;
			for(int j=1;j<i;j++){
				mp = Math.max(mp, Math.max(j*DP[i-j], j*(i-j)));
			}
			DP[i] = mp;
		}
		return DP[n];
	}
	
	public static int maxProductRopesUtil(int n,int[] DP){
		if(n==0 || n==1) return 0;
		int maxProduct = 0;
		for(int i=1;i<n;i++){
			maxProduct = Math.max(i*(n-i),i*maxProductRopes(n-i));
		}
		return maxProduct;
	}

	/*
	 * Works but there is a better approach implemented above
	 */
	
//	public static void recursion(int currentLength,int ropeLenght,ArrayList<Integer> temp){
//		if(currentLength >= ropeLenght){
//			int currentProduct = 1;
//			System.out.println(temp);
//			for(Integer i:temp){
//				currentProduct *= i;
//			}
//			if(currentProduct > maxProduct){
//				maxProduct = currentProduct;
//			}
//			return;
//		}
//		
//		for(int i=currentLength+1;i<=ropeLenght;i++){
//			//add current cut size;
//			temp.add(i-currentLength);
//			recursion(i, ropeLenght, temp);
//			temp.remove(temp.size()-1);
//		}
//		
//		
//	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub\
		System.out.println(maxProductRopes(5));

	}

}
