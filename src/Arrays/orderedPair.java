package Arrays;

public class orderedPair {

	public static void printOrdered(String test){
		printUtil(test, new StringBuilder());
	}
	
	public static void printUtil(String current,StringBuilder temp){
		if(current == null || current.length()==0){
			System.out.println(temp.toString());
			return;
		}
		
		int currentLength = current.length();
		int i=0;
		for(int len=1;len<=currentLength;len++){
//			for(int i=0;i<currentLength-len+1;i++){
				int j=i+len;
				temp.append("(");
				String pair = current.substring(i,j);
				temp.append(pair).append(")");
				printUtil(current.substring(j), temp);	
				temp.setLength(temp.length()-pair.length()-2);
//			}
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array = {1,2,3,4};
		String test = "1234";
		printOrdered(test);
		

	}

}
