package puzzles;
import java.util.*;
public class smsBuffer {

	public static void sendMessage(String sentence, int buffer) {
		int suffixLength = 5;
//		int numberOfMessages = sentence.length() / (buffer)
//				+ (sentence.length() % (buffer) == 0 ? 0 : 1);
//		System.out.println(sentence.length());
//		System.out.println(numberOfMessages);
		String[] words = sentence.split("\\s");
		StringBuilder sb = new StringBuilder();
		int numberOfwhiteSpace =0;
		ArrayList<String> lines = new ArrayList<String>();
		for(int i=0;i<words.length;i++){
			if(words[i].length() + sb.length()< buffer){
				sb.append(words[i]).append(" ");
				numberOfwhiteSpace++;
			}
			else{
				sb.deleteCharAt(sb.length()-1);
				lines.add(sb.toString());
				numberOfwhiteSpace = 0;		
				sb = new StringBuilder();
				sb.append(words[i]).append(" ");
			}
			
			if(i == words.length-1){
				sb.deleteCharAt(sb.length()-1);
				lines.add(sb.toString());
			}
		}
		int totalLines = lines.size();
		for(int i=0;i<lines.size();i++){
			System.out.println(lines.get(i) + "(" + (i+1) + "/" + totalLines + ")");
		}
	}
	
//	public static annotateLines(ArrayList<String> lines)
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String sentence = "one two three four five six seven eight nine";
		int buffer = 15;
		sendMessage(sentence, buffer);

	}

}
