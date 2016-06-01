package puzzles;

public class TurretDefense {

	public static int firstMiss(int[] xs, int[] ys, int[] times) {
		int px =0;
		int py =0;
		int previousTime =0;
		int currentTime =0;
		int bufferTime =0;
		for (int i = 0; i < xs.length; i++) {
			currentTime = Math.abs(xs[i]-px) + Math.abs(ys[i]-py);
			bufferTime = times[i]-previousTime - currentTime;
			if(bufferTime <0) return i;
			px = xs[i];
			py = ys[i];
			previousTime = times[i];
		}

		return -1;

	}

//	public static int computeTime()
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] xs = { 3, 5, 6 };
		int[] ys = { 7, 5, 6 };
		int[] times = { 11, 15, 16 };
		System.out.println(firstMiss(xs, ys, times));

	}

}
