package Graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class alieanAlphabates {
	// Set<Character> alphabates;
	public static Map<Character, List<Character>> alphabates;
	public static List<Character> finalResult;

	public static void extractCharacterSer(List<String> dictionary) {
		alphabates = new HashMap<Character, List<Character>>();
		for (String s : dictionary) {
			char[] current = s.toCharArray();
			for (char c : current) {
				if (alphabates.containsKey(c)) {
					continue;
				} else {
					alphabates.put(c, new ArrayList<Character>());
				}
			}
		}
	}

	public static void DFS() {
		Map<Character, Boolean> visitedMap = new HashMap<Character, Boolean>();
		finalResult = new ArrayList<Character>();
		Set<Character> keys = alphabates.keySet();
		for (Character current : keys) {
			DFSHelper(current, visitedMap);
		}
	}

	public static void DFSHelper(Character current, Map<Character, Boolean> visitedMap) {
		if (visitedMap != null && visitedMap.size() > 0 && visitedMap.containsKey(current)) {
			return;
		}
		
		List<Character> temp = alphabates.get(current);
		if (temp.size() == 0) {
			visitedMap.put(current, true);
			finalResult.add(current);
			return;
		}

		for (Character c : temp) {
			DFSHelper(c, visitedMap);
		}

		visitedMap.put(current, true);
		finalResult.add(current);
		System.out.println(finalResult);
		return;

	}

	public static void makeEdge(char first, char second) {
		if (alphabates.containsKey(first)) {
			List<Character> temp = alphabates.get(first);
			temp.add(second);
		}
	}

	public static void orderAlpahbates(List<String> dictionary) throws Exception {
		if (dictionary == null || dictionary.size() == 0) {
			throw new Exception("dictionary empty");
		}
		String previous = dictionary.get(0);
		String current = "";
		for (int i = 1; i < dictionary.size(); i++) {
			current = dictionary.get(i);
			for (int j = 0; j < Math.min(previous.length(), current.length()); j++) {
				if (previous.charAt(j) != current.charAt(j)) {
					// make a edge from alphabate in previous to alphabate in
					// current
					makeEdge(previous.charAt(j), current.charAt(j));
					break;
				}
			}
			previous = current;
		}
	}

	public static void main(String[] args) {
		List<String> strings = new ArrayList<String>();
		strings.add("xzz");
		strings.add("zxyw");
		strings.add("zxyz");
		strings.add("yzx");
		strings.add("yzw");
		extractCharacterSer(strings);
		try {
			orderAlpahbates(strings);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(alphabates);
		DFS();
		Collections.reverse(finalResult);
		System.out.println(finalResult.toString());
	}
}
