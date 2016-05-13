package Matrix;

public class loanSettlement {

	public static int getMinIndex() {
		return 0;
	}

	public static int getMaxIndex() {
		return 0;
	}

	public static void settleAccountsUtility(int[] amount){
		
	}
	public static void settleAccounts(int[][] graph) {
		int numberOfPerson = graph.length;
		int[] amount = new int[numberOfPerson];
		for(int i=0;i<numberOfPerson;i++)
			for(int j=0;j<numberOfPerson;j++)
				amount[i] += graph[i][j];
		
		settleAccountsUtility(amount);
	}

	public static void main(String[] args) {
		int[][] graph = { { 0, 1000, 2000 }, { 0, 0, 5000 }, { 0, 0, 0 }, };
	}
}
