package uber;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class ChemicalSymbols {

	/*
	 * Brute Force Approach
	 */
	public static Map<Integer, String> hashTable = new HashMap<Integer, String>();
	public static final int _prime = 13;
	public static final int _patternLength = 3;

	public static ArrayList<String> computeSymbol(String[] chemicalNames,
			String[] chemicalSymbols) {
		long time = System.currentTimeMillis();
		ArrayList<String> result = new ArrayList<String>();
		String biggestMatch = "";
		int startIndex = -1;
		int endIndex = -1;
		for (String name : chemicalNames) {
			biggestMatch = "";
			for (String symb : chemicalSymbols) {
				// Pattern pattern = Pattern.compile(symb);
				// Matcher matcher = pattern.matcher(name);
				int index = name.indexOf(symb);
				if (index == -1)
					continue;
				else if (biggestMatch.length() < symb.length()) {
					biggestMatch = symb;
					startIndex = index;
					endIndex = startIndex + symb.length() + 1;
				}
			}
			StringBuilder sb = new StringBuilder(name);
			sb.insert(startIndex, '[');
			sb.insert(endIndex, ']');
			result.add(sb.toString());
		}
		System.out.println("Time taken to complete with BF is"
				+ (System.currentTimeMillis() - time));
		return result;
	}

	/*
	 * Rabin-Karp Algorihm
	 */

	public static ArrayList<String> computeCode(String[] chemicalNames,
			String[] chemicalSymbols) {
		long time = System.currentTimeMillis();
		ArrayList<String> result = new ArrayList<String>();
		int textHash = 0;
		for (String text : chemicalNames) {
			textHash = createHash(text, _patternLength);
			for (int i = 1; i <= text.length() - _patternLength + 1; i++) {
				if (hashTable.containsKey(textHash)
						&& hashTable.get(textHash).equals(
								text.substring(i - 1, i + _patternLength - 1))) {
					String ret = text.replace(hashTable.get(textHash), "["
							+ hashTable.get(textHash) + "]");
					result.add(ret);
					break;
				}

				if (i < text.length() - _patternLength + 1) {
					textHash = computeRollingHash(text, i - 1, i
							+ _patternLength - 1, textHash);
				}
			}
		}
		System.out.println("Time taken to complete with RK is"
				+ (System.currentTimeMillis() - time));
		return result;
	}

	public static int computeRollingHash(String current, int oldIndex,
			int newIndex, int oldHash) {
		int newHash = oldHash - Character.valueOf(current.charAt(oldIndex));
		newHash = newHash / _prime;
		newHash += Character.valueOf(current.charAt(newIndex))
				* Math.pow(_prime, _patternLength - 1);
		return newHash;
	}

	public static void populateHashMap(String[] chemicalSymbols) {
		for (String current : chemicalSymbols) {
			hashTable.put(createHash(current, current.length()), current);
		}
//		System.out.println(hashTable);
	}

	public static int createHash(String current, int end) {
		int hashValue = 0;
		int power = 0;
		for (char c : current.toCharArray()) {
			if (power == end)
				break;
			hashValue += (Character.valueOf(c)) * Math.pow(_prime, power);
			power++;
		}
		return hashValue;
	}

	public static void main(String[] args) {
		String[] chemicalNames = { "Amazon", "Microsoft", "Google" };
		String[] chemicalSymbols = { "Ibm", "Ama", "cro", "Nam", "gle", "abc" };
		System.out.println(computeSymbol(chemicalNames, chemicalSymbols));
		populateHashMap(chemicalSymbols);
		System.out.println(computeCode(chemicalNames, chemicalSymbols));
		// populateHashMap(chemicalSymbols);
	}
}
