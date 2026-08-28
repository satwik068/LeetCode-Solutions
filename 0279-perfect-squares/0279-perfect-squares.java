class Solution {
    public boolean isPerfect(int n){
        for(int i=1; i*i<=n; i++){
            if(i*i==n) return true;
        }
        return false;
    }

    public int mincount(int n, int[] dp){
        if(isPerfect(n)) return 1;
        if(dp[n] != -1) return dp[n];
        int min = n;
        for(int i=1; i*i<=n; i++){
            int count = mincount(i*i, dp) + mincount(n-i*i, dp);
            min = Math.min(min, count);
        }
        return dp[n] = min;
    }
    public int numSquares(int n) {    
        int[] dp = new int[n+1];
        Arrays.fill(dp, -1);
        return mincount(n, dp);

    }
}