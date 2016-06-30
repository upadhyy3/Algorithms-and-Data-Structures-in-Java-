package puzzles;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

// Definition for an interval.
 class Interval {
     int start;
     int end;
     Interval() { start = 0; end = 0; }
     Interval(int s, int e) { start = s; end = e; }
 }
public class meetingRooms {

	public boolean canAttendMeetin(Interval[] intervals){
		if(intervals == null || intervals.length ==0) return false;
		
		Arrays.sort(intervals,new Comparator<Interval>(){

			@Override
			public int compare(Interval o1, Interval o2) {
				// TODO Auto-generated method stub
				if(o1.start == o2.start) return 0;
				else 
				return (o1.start > o2.start?1:-1);
			}
			
		});
		Interval previous = intervals[0];
		for(int i=1;i<intervals.length;i++){
			Interval current = intervals[i];
			if(previous.start >= current.start || previous.end >= current.start){
				return false;
			}
			previous = current;
		}
		
		return true;
	}
	
	public int minMeetingRooms(Interval[] intervals){
        if (intervals == null || intervals.length == 0) {
            return 0;
        }
        int roomCount = 1;
        Arrays.sort(intervals,new Comparator<Interval>(){

			@Override
			public int compare(Interval o1, Interval o2) {
				// TODO Auto-generated method stub
				if(o1.start == o2.start) return 0;
				else 
				return (o1.start > o2.start?1:-1);
			}
			
		});
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        pq.offer(intervals[0].end);
		for(int i=1;i<intervals.length;i++){
			Interval current = intervals[i];
			
			if(current.start<pq.peek()){
				roomCount++;
			}
			else{
				pq.poll();
			}
			pq.offer(current.end);
		}
		
        return roomCount;
	}
	
	public static void main(String[] args) {
		Interval[] intervals = {new Interval(0,30),new Interval(5,10),new Interval(15,20)};
		meetingRooms mr = new meetingRooms();
//		System.out.println(mr.canAttendMeetin(intervals));
		System.out.println(mr.minMeetingRooms(intervals));
	}
}
