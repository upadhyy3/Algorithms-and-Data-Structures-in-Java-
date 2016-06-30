package uber;

public class permuteParantheses {

	public static void printParantheses(int number){
		int leftParantheses = number;
		int rightParantheses = number;
		recursiveHelper(leftParantheses, rightParantheses,new StringBuilder());
	}
	
	public static void recursiveHelper(int left,int right,StringBuilder sb)
	{
		if(right == 0){
			System.out.println(sb.toString());
			System.out.println(" ");
			return;
		}
		
		if(right>left){
			sb.append(")");
			recursiveHelper(left, right-1,sb);
			sb.deleteCharAt(sb.length()-1);
		}
		
		if(left>0){
			sb.append("(");
			recursiveHelper(left-1, right,sb);
			sb.deleteCharAt(sb.length()-1);
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		printParantheses(3);
	}

}
