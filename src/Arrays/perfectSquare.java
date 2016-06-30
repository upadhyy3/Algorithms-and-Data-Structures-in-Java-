package Arrays;

public class perfectSquare {

    public boolean isPerfectSquare(int num) {
        if(num ==0 || num == 1) return true;
        int left = 1;
        int right = num/2;
        
        while(left<=right){
            int mid = left + (right-left)/2;
            double square = mid*mid;
            System.out.println(mid);
            System.out.println(square);
            if(square == num) return true;
            else if(square > num){
                right = mid-1;
            }
            else{
                left  = mid+1;
            }
        }
        
        return false;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		perfectSquare ps = new perfectSquare();
		System.out.println(ps.isPerfectSquare(64*64));
	}

}
