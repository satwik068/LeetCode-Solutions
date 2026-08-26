class Solution {

    // public int fibo(int n, int[] dp) {
    //     if(n<=1) return n;
    //     if(dp[n]!=0) return dp[n];
    //     int ans = fibo(n-1, dp)+fibo(n-2, dp);
    //     dp[n] = ans;
    //     return ans;
    // }
    public int fib(int n) {
        // int[] dp = new int[n+1];
        // return fibo(n, dp);

        // tabulation dp
        if(n<=1) return n;
        int[] dp = new int[n+1];
        dp[0] = 0; dp[1] = 1;
        for(int i=2; i<n+1; i++){
            dp[i] = dp[i-1] +dp[i-2];
        }
        return dp[n];

    }
}