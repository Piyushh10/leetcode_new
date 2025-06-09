class Solution {
    public int maxProfit(int[] prices) {
        int minP = prices[0];
        int maxP = 0;
        int n = prices.length;
        for(int i = 0; i< n; i++){
            int profit = prices[i] - minP;
            maxP = Math.max(maxP, profit);
            minP = Math.min(minP, prices[i]);
        }
        return maxP;
    }
}

/*
DP m stocks

approach-
if you are selling on (i)th day, you buy on the minimum price from 0 to (i-1)
calc minimum and profit for each iteration


*/