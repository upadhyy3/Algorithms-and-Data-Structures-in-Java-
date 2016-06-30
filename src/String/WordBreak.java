package String;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class WordBreak {
	
    public boolean wordBreak(String s, Set<String> wordDict) {
        boolean[] flagArray = new boolean[s.length()+1];
        flagArray[0] = true;
        for(int i=0;i<s.length();i++){
            if(!flagArray[i]) continue;
            
            for(String current:wordDict){
                int currentLength = current.length();
                if(i+currentLength > s.length()) continue;
                String sub = s.substring(i,i+currentLength);
                if(sub.equals(current)) flagArray[i+currentLength] = true;
            }
        }
        
        return flagArray[s.length()];
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Set<String> wordDict = new HashSet<String>();
		String[] dict = {"a","b","bbb","bbbb"};
		wordDict.addAll(Arrays.asList(dict));
		WordBreak wb = new WordBreak();
		System.out.println(wb.wordBreak("bb", wordDict));
	}

}
