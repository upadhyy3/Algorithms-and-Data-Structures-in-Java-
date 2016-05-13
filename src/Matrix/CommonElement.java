package Matrix;

public class CommonElement {

	public static int findCommonMatrix(int[][] temp){
		int row = temp.length;
		int col = temp[0].length;
		int currentElement = 0;
		int element = -1;
		boolean flag = false;
		for (int firstColoumn = 0; firstColoumn < col; firstColoumn++) {
			currentElement = temp[0][firstColoumn];
			for (int i = 1; i < row; i++) {
				if(binarySearch(temp[i], currentElement)){
					flag = true;
					element = currentElement;
					continue;
				}
				else{
					flag = false;
					element = -1;
					break;
				}
			}
			if(flag) return element;
		}
		
		return element;
	}
	
	public static boolean binarySearch(int[] currentRow,int currentElement){
		int low = 0;
		int high = currentRow.length;
		
		while(low<=high){
			int mid = low + (high-low)/2;
			if(currentRow[mid] == currentElement) return true;
			else if(currentRow[mid] > currentElement){
				high = mid-1;
			}
			else{
				low = mid+1;
			}
		}
		return false;
	}
	
	public static void main(String[] args){
		int[][] mat= {{1,2,3,4,5},{2,3,4,5,6},{3,4,5,6,7},{4,5,6,7,8}};
		System.out.println(findCommonMatrix(mat));
	}
}
