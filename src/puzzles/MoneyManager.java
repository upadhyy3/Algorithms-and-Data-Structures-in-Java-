package puzzles;

import java.util.*;
class work implements Comparable<work>{
	int experience;
	int money;
	work(int experience,int money){
		this.experience = experience;
		this.money = money;
	}
	
	@Override	
	public int compareTo(work o){
		int ret = this.money- o.money; 
//		return this.experience - o.experience;
		
		if(ret ==0){
			return this.experience - o.experience;
		}
		
		return ret;
	}
}
public class MoneyManager {

	public static int getbest(int[] a, int[] b, int X){
		ArrayList<work> objList = new ArrayList<work>();
		int totalEarings = 0;
		int currentExperience = 0;
		for(int i=0;i<a.length;i++){
			objList.add(new work(a[i],b[i]));
		}	
		Collections.sort(objList);
		
		for(int i=0;i<objList.size();i++){
			currentExperience += objList.get(i).experience;
			if(i == (objList.size()/2)){
				currentExperience += X;
			}
			totalEarings += currentExperience*objList.get(i).money;

			System.out.println("Total Earning after adding experience =" + objList.get(i).experience +
					" and current money" + objList.get(i).money +"->");
			System.out.println("CurrentExperience:" + currentExperience);
			System.out.println("Total Earning" + totalEarings);
		}
		
		return totalEarings;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = {30,13,28,59,26,62,48,75,6,69,94,51};//{4,4,6,6};
		int[] b = {4,6,4,5,4,3,1,5,6,5,2,2};//{2,2,3,3};
		int X = 62;
		int result = getbest(a, b, X);
		System.out.println(result);
	}

}
