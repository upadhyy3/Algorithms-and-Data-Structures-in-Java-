package Trees;

class Node {
	Node[] children;
	char value;
	boolean endOfWord;

	Node(char value) {
		this.value = value;
		children = new Node[26];
		endOfWord = false;
	}
}

public class WordDictionary {

	// Adds a word into the data structure.
	Node root;

	WordDictionary() {
		root = new Node('#');
	}

	public void addWord(String word) {
		Node[] current = root.children;
		int currentIndex = 0;
		for (char c : word.toCharArray()) {
			currentIndex++;
			if (current[c - 'a'] == null) {
				current[c - 'a'] = new Node(c);
				if (currentIndex == word.length()) {
					current[c - 'a'].endOfWord = true;
				}
				current = current[c - 'a'].children;
			} else {
				if (currentIndex == word.length()) {
					current[c - 'a'].endOfWord = true;
				}
				current = current[c - 'a'].children;
			}
		}
	}

	// Returns if the word is in the data structure. A word could
	// contain the dot character '.' to represent any one letter.
	public boolean search(String word) {

		Node[] current = root.children;
		if (searchUtil(word, current)) {
			return true;
		} else {
			return false;
		}
	}

	public boolean searchUtil(String word, Node[] current) {
		if (word == null || word.length() == 0) {
			for (int i = 0; i < 26; i++) {
				if (current[i] != null)
					return false;
			}
			return true;
		}

		if (current == null) {
			return false;
		}

		char c = word.charAt(0);
		if (c == '.') {
			// check next level children for a match
			for (int i = 0; i < 26; i++) {
				if (current[i] != null
						&& ((word.substring(1).length() == 0 && current[i].endOfWord) || searchUtil(
								word.substring(1), current[i].children))) {
					return true;
				}
			}
			return false;
		} else if (current[c - 'a'] == null) {
			return false;
		} else {
			if (word.substring(1).length() == 0 && current[c - 'a'].endOfWord) {
				return true;
			}
			if (searchUtil(word.substring(1), current[c - 'a'].children)) {
				return true;
			} else {
				return false;
			}
		}
	}

	public static void main(String[] args) {
		WordDictionary wordDictionary = new WordDictionary();
		wordDictionary.addWord("a");
		wordDictionary.addWord("ab");
		System.out.println(wordDictionary.search("a"));
		wordDictionary.search("a.");
		wordDictionary.search("ab");
		wordDictionary.search(".a");
		wordDictionary.search(".b");
		wordDictionary.search("ab.");
		System.out.println(wordDictionary.search("."));
		wordDictionary.search("..");

	}
}

// Your WordDictionary object will be instantiated and called as such:
// WordDictionary wordDictionary = new WordDictionary();
// wordDictionary.addWord("word");
// wordDictionary.search("pattern");
