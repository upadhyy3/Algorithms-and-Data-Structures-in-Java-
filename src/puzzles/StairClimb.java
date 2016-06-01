package puzzles;

public class StairClimb {

	public static int stridesTaken(int[] flights, int stairsPerStride) {
		int numberOfFlights = flights.length;
		int numberOfStrides = 0;
		
		for(int i=0;i<numberOfFlights;i++){
			numberOfStrides += flights[i]/stairsPerStride + ((flights[i]%stairsPerStride == 0)?0:1);
		}
		numberOfStrides += (numberOfFlights-1)*2;
		return numberOfStrides;
	}
	public static void main(String[] args) {
		int[] flights = {5,11,9,13,8,30,14};	
		int stairsPerStride =3;
		System.out.println(stridesTaken(flights,stairsPerStride));		
	}

}
