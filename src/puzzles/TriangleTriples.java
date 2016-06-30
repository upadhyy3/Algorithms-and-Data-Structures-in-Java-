package puzzles;

public class TriangleTriples {

	
	public int count(int A,int B,int C){
		int count =0;
		int max = Math.max(A, Math.max(B,C));
		int dimension = 0;
		if(max == A){
			dimension = Math.min(B+C, A);
		}else if(max == B){
			
		}else{
			
		}
		return count;
	}
	public boolean isTriangle(int a,int b,int c){
		if(a+b> c || a+c >b || b+c > a){
			return true;
		}
		return false;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		System.out.println(Integer.MAX_VALUE);

	}

}
