package puzzles;

public class ExerciseMachine {

	public static int getPercentages(String time){
		String[] times = time.split(":");
		int percentage = 1;
		long timeInSec = Integer.parseInt(times[0])*3600 + Integer.parseInt(times[1])*60 + Integer.parseInt(times[2]);
		for(;percentage<100;percentage++){
			if((percentage*timeInSec)%100 ==0) break;
		}
		
		return 99/percentage;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String time = "23:59:59";
		System.out.println(getPercentages(time));
	}

}
