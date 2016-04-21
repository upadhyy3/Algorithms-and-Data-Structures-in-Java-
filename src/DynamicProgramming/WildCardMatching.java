package DynamicProgramming;

public class WildCardMatching {
	 public boolean isMatch(String s, String p) {
	        if(s=="" && p=="") return true;
	       char[] givenString = s.toCharArray();
	       char[] givenPattern = p.toCharArray();
	       
	       int wildcardIndex = 0;
	       boolean isFirst = true;
	       for(int i=0;i<givenPattern.length;i++)
	       {
	           if(givenPattern[i] == '*'){
	                if(isFirst){
	                  givenPattern[wildcardIndex++] = givenPattern[i];
	                  isFirst = false;
	                }
	            }
	            else{
	                isFirst = true;
	                givenPattern[wildcardIndex++] = givenPattern[i];
	            }
	       }
	       
	       boolean[][] DP = new boolean[s.length() + 1][wildcardIndex+1];
	       if(wildcardIndex>0 && givenPattern[0] == '*'){
	           DP[0][1] = true;
	       }
	       
	       DP[0][0] = true;
	       for(int i=1;i<s.length()+1;i++){
	           for(int j=1;j<wildcardIndex+1;j++){
	               if(givenPattern[j-1] == '?' || givenPattern[j-1] == givenString[i-1]){
	                   DP[i][j] = DP[i-1][j-1];
	               }
	               else if(givenPattern[j-1] == '*'){
	                   DP[i][j] = (DP[i-1][j] || DP[i][j-1]);
	               }
	               else{
	                   DP[i][j] = false;
	               }
	           }
	       }
	       
	       return DP[s.length()][wildcardIndex];
	    }

}
