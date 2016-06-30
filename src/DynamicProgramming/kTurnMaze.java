package DynamicProgramming;

public class kTurnMaze {

	public static int result =0;
	public static int numberOfPaths(int rows,int cols,int k){
		//direction 0 ->down && 1->right
		int i=1;
		int j=1;
		recursiveUtil(i+1,j, 0, rows, cols, 0, k);
		recursiveUtil(i,j+1, 1, rows, cols, 0, k);
		return result;
	}
	
	public static void recursiveUtil(int i,int j,int direction,int rows,int cols , int turns,int k){
		if(i>rows || j> rows || turns > k){
			return;
		}		
		else if(i== rows && j == cols){
			System.out.println(k);
			if(turns <= k){
				result++;
			}
			return;
		}
		
		if(direction == 0){
			//continue in the direction
				recursiveUtil(i+1, j, direction, rows, cols, turns, k);
			//change direction
				recursiveUtil(i, j+1, 1, rows, cols, turns+1, k);
		}
		else{
			
			//continue in the direction
				recursiveUtil(i, j+1, direction, rows, cols, turns, k);
			
			//change direction
				recursiveUtil(i+1, j, 0, rows, cols, turns+1, k);
		}
	}
	
	public static int[][][][] DP;
	public static int countPathUtils(int i,int j,int k,int d){
		if(i<0 || j<0) return 0;
		if(i==0 && j==0) return 1;
		
		if(k==0){
			if(d==0 && j==0) return 1;
			
			if(d==1 && i==0) return 1;
			
			return 0;
		}
		
		if(DP[i][j][k][d] !=0 ) return DP[i][j][k][d];
		
		if(d == 0){
			return DP[i][j][k][d]= countPathUtils(i-1, j, k, 0) + countPathUtils(i, j-1, k-1, 1);
		}
		else{
			return DP[i][j][k][d]= countPathUtils(i-1, j, k-1, 0) + countPathUtils(i, j-1, k, 1);
		}
	}
	
	public static int countPaths(int i,int j,int k){
		DP = new int[i+1][j+1][k+1][2];
		// 0-> row 1 -> col
		if(i==0||j==0) return 1;
		return countPathUtils(i-1, j, k, 0) + countPathUtils(i, j-1, k,1);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(numberOfPaths(3, 3, 2));
		System.out.println(countPaths(2, 2, 2));
	}

}
