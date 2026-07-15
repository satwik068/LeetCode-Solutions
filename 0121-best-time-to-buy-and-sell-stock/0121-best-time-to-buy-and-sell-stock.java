class Solution {
    public int maxProfit(int[] prices) {
        int min = Integer.MAX_VALUE;
        int maxp = Integer.MIN_VALUE;
        for(int i=0; i<prices.length; i++){
            min = Math.min(min, prices[i]);

            int profit = prices[i]-min;
            maxp = Math.max(maxp, profit);

        }
        return maxp;
    }
}