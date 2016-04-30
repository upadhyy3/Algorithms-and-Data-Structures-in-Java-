package DynamicProgramming;
import java.util.Arrays;
public class cuttingARod {
	public static int cuttingRodPrice(int length,int[] prices){
		int maxProfit =0;
		 int[] DP = new int[length+1];
		 DP[0] = 0;
		 int maxValue =0;
		 for(int i=1;i<=length;i++){
			 for(int j=0;j<i;j++){
				 maxValue = Math.max(maxValue,DP[i-j-1]+prices[j]);
			 }
			 DP[i] = maxValue;
		 }
		 System.out.println(Arrays.toString(DP));
		return DP[length];
	}
	
	public static void main(String[] args){
		int[] prices = {1,5,8,9,10,17,17,20};
		System.out.println(cuttingRodPrice(8, prices));
	}
}
