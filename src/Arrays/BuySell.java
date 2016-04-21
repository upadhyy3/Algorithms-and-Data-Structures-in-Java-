package Arrays;

public class BuySell {

    public int maxProfit(int[] prices) {
        if(prices == null || prices.length ==0) return 0;
        int[] DPLeft = new int[prices.length];
        int[] DPRight = new int[prices.length];
        int profit =0;
        
        DPLeft[0] = 0;
        int min =prices[0];
        int max =prices[prices.length-1];
        //left to rigth
        for(int i=1;i<prices.length;i++){
            min = Math.min(min,prices[i]);
            DPLeft[i] = Math.max(DPLeft[i-1],prices[i]-min);
        }
        
        DPRight[prices.length-1] = 0;
        for(int i=prices.length-2;i>=0;i--){
            max = Math.max(max,prices[i]);
            DPRight[i] = Math.max(DPRight[i+1],max-prices[i]);
        }
        
        for(int i=0;i<prices.length;i++){
            profit = Math.max(profit,DPLeft[i]+DPRight[i]);
        }
    
        return profit;
    }
}
