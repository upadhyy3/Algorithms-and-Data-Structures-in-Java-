package puzzles;

import java.security.acl.LastOwnerException;
import java.util.ArrayList;
import java.util.List;

public class textJustification {
	public List<String> fullJustify(String[] words, int maxWidth) {
		List<String> result = new ArrayList<String>();
		String temp = null;
		int currentLength = 0;
		int whiteSpaces = 0;
		boolean isLastLine = false;
		ArrayList<String> currentLine = new ArrayList<String>();
		for (int i = 0; i < words.length; i++) {
			String current = words[i];
			if (currentLength + whiteSpaces + current.length() > maxWidth) {
				temp = fillSpace(currentLine, currentLength, maxWidth,
						isLastLine);
				result.add(temp);
				currentLength = 0;
				whiteSpaces = 0;
				currentLine.clear();
			}
			currentLine.add(current);
			if (i == words.length - 1)
				isLastLine = true;
			currentLength += current.length();
			whiteSpaces++;
		}
		if (currentLine.size() > 0) {
			temp = fillSpace(currentLine, currentLength, maxWidth, isLastLine);
//			System.out.println(currentLine);
			result.add(temp);
		}
		return result;
	}

	public String fillSpace(ArrayList<String> currentLine, int currentLength,
			int maxWidth, boolean lastLine) {
		int whiteSpaces = maxWidth - currentLength;
		int numberOWords = currentLine.size();
		StringBuilder sb = new StringBuilder();
		int currentSpace = 0;
		if (lastLine) {
			for (String current : currentLine) {
				if(current.length()==0) break;
				sb.append(current);
				if(currentSpace<whiteSpaces){
					sb.append(" ");
				}
				currentSpace++;
			}
			while (currentSpace < whiteSpaces) {
				sb.append(" ");
				currentSpace++;
			}

			return sb.toString();
		}
		else if(numberOWords == 1){
			sb.append(currentLine.get(0));
			while (currentSpace < whiteSpaces) {
				sb.append(" ");
				currentSpace++;
			}
			return sb.toString();
		}
		int spaceInBetween = whiteSpaces / (numberOWords - 1);
		int leftOver = whiteSpaces % (numberOWords - 1);

		for (int i = 0; i < currentLine.size(); i++) {
			if (i < currentLine.size() - 1) {
				sb.append(currentLine.get(i));
				while (currentSpace < spaceInBetween) {
					sb.append(" ");
					currentSpace++;
				}
				if (leftOver > 0) {
					sb.append(" ");
					leftOver--;
				}
				currentSpace = 0;
			} else {
				sb.append(currentLine.get(i));
			}
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		String[] words = {"Listen","to    ","many, ","speak ","to" ,"a","few.  "};
		textJustification tj = new textJustification();
		System.out.println(tj.fullJustify(words, 6));
	}
}

