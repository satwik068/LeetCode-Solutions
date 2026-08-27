class Solution {
    public int count(int m, int n, int[][] dp) {
        if(m==1 || n==1) return 1;
        if(dp[m-1][n-1] != 0) return dp[m-1][n-1];
        int left = count(m-1, n, dp);
        int right = count(m, n-1, dp);
        return dp[m-1][n-1] = left+right;
    }
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        return count(m, n, dp);
    }
}
// class Solution {
//     public int uniquePaths(int m, int n) {
        
//     }
// }