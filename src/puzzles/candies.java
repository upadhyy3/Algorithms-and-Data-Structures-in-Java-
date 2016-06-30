package puzzles;
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
public class candies {


	    public static long minCandies(int[] ratings){
	        if(ratings == null || ratings.length ==0) return 0;
	        int length = ratings.length;
	        int[] DP = new int[length];
	        int count = 0;
//	        Arrays.fill(DP,1);
	        DP[0] = 1;
	        for(int i=1;i<length;i++){
	        	DP[i] = 1;
	            if(ratings[i] > ratings[i-1]){
	                DP[i] = DP[i-1] + 1;
	            }
	            else {
//		            if(ratings[i-1] > ratings[i] && DP[i-1] <= DP[i]){
////		                DP[i-1]++;
//		                int j = i-1;
//		                while(j>=0 && ratings[j] > ratings[j+1] && DP[j]<=DP[j+1]){
//		                    DP[j]++;
//		                    j--;
//		                }
//		            }
		            for(int j = i; j > 0 && ratings[j] < ratings[j-1] && DP[j] == DP[j-1]; DP[--j] += 1){}
	            }
	        }
	        System.out.println(Arrays.toString(DP));
	        for(int i=0;i<DP.length;i++){
	            count += DP[i];
	        }
	        return count;
	    }
	    public static void main(String[] args) {
	        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
//	        Scanner scan = new Scanner(System.in);
//	        int n = scan.nextInt();
//	        int[] ratings = new int[n];
//	        int i=0;
//	        while(i<n){
//	            ratings[i] = scan.nextInt();
//	            i++;
//	        }
//	        scan.close();
	        int[] ratings = {2,4,2,6,1,7,8,9,2,1};
	        System.out.println(minCandies(ratings));
	    }
	
}
