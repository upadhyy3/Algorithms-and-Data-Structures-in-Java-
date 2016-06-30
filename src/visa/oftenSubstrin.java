package visa;

import java.util.*;

public class oftenSubstrin {

	static int mostFrequent = 1;

	public static int countOfFrequent(String string, int k, int l, int m) {
		if (string == null || string.length() == 0)
			return 0;
		

		Map<String, Integer> map = new HashMap<String, Integer>();
		int length = string.length();
		for (int i = k; i <= l; i++) {
			for (int j = 0; j <= length - i; j++) {
				String current = string.substring(j, j + i);
				System.out.println(current);
				if (map.containsKey(current)) {
					int count = map.get(current);
					count++;
					map.put(current,count);
					System.out.println("Count" + count);
					if (count > mostFrequent) {
						mostFrequent = count;
					}
				} else if (isValid(current, m)) {
					map.put(current, 1);
				}
			}
		}

		return mostFrequent;
	}

	public static boolean isValid(String current, int m) {
		boolean[] charCount = new boolean[26];
		int count =0;
		for (char c : current.toCharArray()) {
			
			if(charCount[c - 'a']){
				continue;
			}
			else{
				charCount[c - 'a'] = true;
				count++;
			}
		}
		
		if(count > m) return false;
		else return true;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println(countOfFrequent("abcabcabcabc", 2, 4, 2));

	}

}
