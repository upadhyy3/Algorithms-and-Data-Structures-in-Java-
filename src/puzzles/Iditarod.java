package puzzles;


class Time{
	int time;
	int day;
	Time(int time,int day){
		this.time = time;
		this.day = day;
	}
}
public class Iditarod {

	public static final String _startTime = "8:00 AM, DAY 1";

	public static int avgMinutes(String[] times) {
		double avgTime = 0;
		int[] timesInMinute = computeTimeInMinutes(times);
		double sum =0;
		for(int i:timesInMinute) sum+=i;
		avgTime = sum/timesInMinute.length;
		double fraction = avgTime - (int)avgTime;
		int result = (int) avgTime;
		if(fraction>= 0.5d){
			result++;
		}
		return result;
	}

	public static int[] computeTimeInMinutes(String[] times) {
		int[] result = new int[times.length];
		Time startTime = preProcees(_startTime);
		Time currentTime = null;
		int index =0;
		for(String current:times){
			currentTime = preProcees(current);
			result[index] = computeTime(currentTime, startTime);
			index++;
		}
		return result;
	}
	public static int computeTime(Time current,Time start){
		int days = current.day - start.day;
		int minutes = days*24*60 + (current.time - start.time);
		return minutes;
	}
	public static Time preProcees(String time){
		String[] tokens = time.split("\\s");
		String[] finishTime = tokens[0].split(":");
		int hour = Integer.parseInt(finishTime[0]);
		int minutes = Integer.parseInt(finishTime[1]);
		if(tokens[1].startsWith("P") && hour < 12){
			hour+= 12;
		}
		else if(hour == 12 && tokens[1].startsWith("A")){
			hour = 0;
		}
		int timeInMinutes = hour*60 + minutes;
		int day = Integer.parseInt(tokens[3]);
		Time timeObject = new Time(timeInMinutes,day);
		return timeObject;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] times = {"02:00 PM, DAY 19","02:00 PM, DAY 20", "01:58 PM, DAY 20"};
//		System.out.println(preProcees(times[0]).time );
		System.out.println(avgMinutes(times));

	}

}
