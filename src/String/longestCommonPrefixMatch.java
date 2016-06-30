package String;

import java.util.ArrayList;

import LinkedList.addTwoNumber;

class Node {
	char value;
	int count;
	Node[] children;

	Node(char value, int count) {
		this.value = value;
		this.count = count;
		this.children = new Node[256];
	}
}

public class longestCommonPrefixMatch {

	public String longestCommonPrefix(String[] strs) {
		Node root = new Node('#', 0);
		for (String current : strs) {
			addToTrie(current, root);
		}
		String result = findPrefix(root, new StringBuilder(), strs.length);
		return result;
	}

	public void addToTrie(String current, Node root) {
		char[] array = current.toCharArray();
		int len = current.length();
		for (int i = 0; i < len; i++) {
			if (root.children[array[i]] == null) {
				root.children[array[i]] = new Node(array[i], 1);
			} else {
				root.children[array[i]].count++;
			}
			root = root.children[array[i]];
		}

	}

	public String findPrefix(Node root, StringBuilder prefix,
			int numberOfStrings) {
		// Corner case
		if (root == null)
			return "";

		// Base case

		for (int i = 0; i < 256; i++) {
			if (root.children[i] != null) {
				if (root.children[i].count < numberOfStrings) {
					return prefix.toString();
				} else {
					prefix.append(root.children[i].value);
					root = root.children[i];
					i=0;
				}
			}
		}
		return prefix.toString();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] strs = { "a"};
		longestCommonPrefixMatch lp = new longestCommonPrefixMatch();
		System.out.println(lp.longestCommonPrefix(strs));
	}

}
