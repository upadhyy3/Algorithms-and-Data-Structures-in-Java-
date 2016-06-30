package String;

import java.util.*;

public class DNAsequence {

	int prime = 13;

	public List<String> findRepeatedDnaSequences(String s) {
		List<String> result = new ArrayList<String>();

		for (int i = 0; i <= s.length() - 10; i++) {
			String currentPattern = s.substring(i, i + 10);
			System.out.println("current Pattern:" + currentPattern);
			int j = i + 1;
			if (j > s.length() - 10)
				break;
			String text = s.substring(j, j + 10);
			long patternHash = createHash(currentPattern);
			long textHash = createHash(text);
			for (int k = j + 1; k <= s.length() - 10 + 1; k++) {
				if (patternHash == textHash && text.equals(currentPattern)
						&& !result.contains(text)) {
					result.add(text);
				}

				if (k < s.length() - 10 + 1) {
					text = s.substring(k, k + 10);
					System.out.println("text is" + text);
					textHash = rehash(s, textHash, k - 1, k + 10 - 1);
				}
			}

		}

		return result;
	}

	// public List<String> findRepeatedDnaSequences(String s) {
	// List<String> result = new ArrayList<String>();
	// Map<Long, String> map = new HashMap<Long, String>();
	// String currentPattern = s.substring(0, 10);
	// long patternHash = createHash(currentPattern);
	// map.put(patternHash, currentPattern);
	// for (int i = 1; i <= s.length() - 10; i++) {
	// patternHash = rehash(s, patternHash, i - 1, i + 10 - 1);
	// if (map.containsKey(patternHash)) {
	// String text = s.substring(i, i + 10);
	// if (text.equals(map.get(patternHash)) && !result.contains(text)) {
	// result.add(text);
	// }
	// }
	//
	// }
	//
	// return result;
	// }

	public long rehash(String text, long oldHash, int oldIndex, int currentIndex) {
		long newHash = oldHash - text.charAt(oldIndex);
		newHash = newHash / prime;
		newHash += text.charAt(currentIndex) * Math.pow(prime, 9);
		return newHash;
	}

	public long createHash(String s) {
		long hash = 0;
		for (int i = 0; i < s.length(); i++) {
			hash += s.charAt(i) * Math.pow(prime, i);
		}
		return hash;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT";
		DNAsequence ds = new DNAsequence();
		System.out.println(ds.findRepeatedDnaSequences(s));

	}

}
