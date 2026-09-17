class Solution {
    public long count(int i, int[] coins, int A, long[][] dp){
        if(i==coins.length){
            if(A==0) return 0;
            else return Integer.MAX_VALUE;
        }
        if(dp[i][A] != -1) return dp[i][A];
        long skip = count(i+1, coins, A, dp);
        if(coins[i]>A) return dp[i][A] = skip;
        long pick = 1 + count(i, coins, A-coins[i], dp);
        return dp[i][A] = Math.min(skip, pick);
    }
    public int coinChange(int[] coins, int amount) {
        long[][] dp = new long[coins.length][amount+1];
        for(long[] a:dp){
            Arrays.fill(a, -1);
        }
        int ans = (int)count(0, coins, amount, dp);
        if(ans==Integer.MAX_VALUE) return -1;
        return ans;
    }
}