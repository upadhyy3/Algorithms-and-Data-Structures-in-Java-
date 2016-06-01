package puzzles;

public class TVTower {

	public static  double minRadius(int[] x, int[] y){
		double maxDistance = Integer.MIN_VALUE;
		for(int i=0;i<x.length;i++){
			for(int j=0;j<y.length;j++){
				maxDistance = Math.max(maxDistance, computeDitance(x[i], y[i], x[j], y[j]));
			}
		}
		maxDistance = maxDistance*0.5;
		return maxDistance;
	}
	
	public static double computeDitance(int x1,int y1,int x2,int y2){
		double result = Math.sqrt(Math.pow((x1-x2), 2) + Math.pow((y1-y2), 2));
		return result;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] xs = {5, 3, -4, 2};
		int[] ys = {0, 4, 3, 2};
		System.out.println(minRadius(xs, ys));
	}

}
