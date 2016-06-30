package puzzles;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class stableDNA {

	 static Set<Character> excessSet = new HashSet<Character>();
	    static int excessCount =0;
	    static void getExcessCharacters(String str){
	        int correctCount = str.length()/4;
	        Map<Character,Integer> map = new HashMap<Character,Integer>();
	        for(char c: str.toCharArray()){
	            if(map.containsKey(c)){
	                int updateCount = map.get(c);
	                map.put(c,++updateCount);
	            }
	            else{
	                map.put(c,1);
	            }
	        }
	        System.out.println(map);

	        for(Map.Entry<Character,Integer> entry:map.entrySet()){
	            if(correctCount < entry.getValue()){
	                excessCount += entry.getValue()-correctCount;
	                excessSet.add(entry.getKey());
	            }
	            
	        }
	    }
	    
	    static int balanceDNA(String str){
	        getExcessCharacters(str);
	        System.out.println(excessCount);
	        System.out.println(excessSet);
	        return 0;
	    }
	    
	    public static void main(String[] args) {
	        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
	        try{
	            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	            String s = br.readLine();
	            System.out.println(balanceDNA(s));
	            br.close();
	        }
	        catch(IOException io){
	            System.out.println(io.getMessage());
	        }
	    }

}
