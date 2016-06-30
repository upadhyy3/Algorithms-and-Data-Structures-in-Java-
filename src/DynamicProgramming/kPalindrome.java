package DynamicProgramming;

public class kPalindrome {

	/*
	 * Find out the longest palindrome subsequence
	 * return difference between the length of given string and longest palindromic subsequence
	 */
	
	public static int countOfCharacters(String test){
		if(test == null || test.length()==0) return 0;
		int length = test.length();
		int[][] DP = new int[length][length];
		for(int i=0;i<test.length();i++){
			DP[i][i] = 1;
		}
		
		for(int len =2;len<=length;len++){
			for(int i=0;i<length-len+1;i++){
				int j = i+len-1;
				if(test.charAt(i) == test.charAt(j) && len==2){
					DP[i][j] = 2;
				}
				else if(test.charAt(i) == test.charAt(j)){
					DP[i][j] = Math.max(DP[i][j-1], DP[i+1][j]) +2;
				}
				else{
					
					DP[i][j] = Math.max(DP[i][j-1], DP[i+1][j]);
				}
			}
		}
		
		return (test.length()-DP[0][test.length()-1]);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String test = "abcdeca";
		System.out.println(countOfCharacters(test));

	}

}
