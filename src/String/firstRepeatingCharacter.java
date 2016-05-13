package String;

public class firstRepeatingCharacter {

	public static char findFirstRepwatingChar(String s){
		boolean[] map = new boolean[256];
		for(char c:s.toCharArray()){
			if(map[c]){
				return c;
			}
			else{
				map[c] = true;
			}
		}
		return ' ';
	}
	public static void main(String[] args){
		String tst = "shivamisagoodboy";
		System.out.println(findFirstRepwatingChar(tst));
	}
}
