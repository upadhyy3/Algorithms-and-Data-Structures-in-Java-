package uber;
import java.util.*;

 
public class groupAnagram{

	HashMap<Character,Integer> primeMap = new HashMap<Character,Integer>();
	public void populateMap(){
		int[] primes = {2,3,5,7,11,13,17,19,23,29,31,37,41,43,47,53,59,61,67,71,73,79,83,89,97,101};
		for( char c='a';c<='z';c++){
			primeMap.put(c, primes[c-'a']);
		}
	}
	
    public double computeKey(String current){
    	double key = 1;
    	for(char c: current.toCharArray()){
    		key*= primeMap.get(c);
    	}
		return key;
    }
	
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<List<String>>();
        Map<Double,ArrayList<String>> map = new HashMap<Double,ArrayList<String>>();
        populateMap();
        double key = 0d;
        for(String current:strs){
        	key = computeKey(current);
        	if(map.containsKey(key)){
        		ArrayList<String> temp = map.get(key);
        		temp.add(current);
        		map.put(key,temp);      
        	}
        	else{
        		ArrayList<String> temp = new ArrayList<String>();
        		temp.add(current);
        		map.put(key,temp);
        	}
        }
        
        result.addAll(map.values());
        return result;
    }
    

    
	public static void main(String[] args) {
		String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
		groupAnagram ga = new groupAnagram();
		System.out.println(ga.groupAnagrams(strs));
		
	}
}
