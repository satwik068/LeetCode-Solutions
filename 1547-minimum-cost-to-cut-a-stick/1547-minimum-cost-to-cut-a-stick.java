class Solution {

    public int cost(int k, int i, int j, int[] cuts, int[][] dp){
        if(j-i <= 1) return 0;
        if(k>=j) return Integer.MAX_VALUE;
        if(dp[i][j] != -1) return dp[i][j];

        int skip = cost(k+1, i, j, cuts, dp);

        int curr = cuts[j] - cuts[i];
        int left = cost(1, i, k, cuts, dp);
        int right = cost(k+1, k, j, cuts, dp);

        int pick = curr + left + right;

        return dp[i][j] = Math.min(skip, pick);



    }
    public int minCost(int n, int[] cuts) {
        Arrays.sort(cuts);
        int m = cuts.length;
        int[] newcuts = new int[m+2]; 
        newcuts[m+2-1] = n;
        for(int i=0; i<m; i++){
            newcuts[i+1] = cuts[i];
        }

        int l = newcuts.length;
        int[][] dp = new int[l][l];
        for(int[] a:dp){
            Arrays.fill(a, -1);
        }
        int ans = cost(1, 0, l-1, newcuts, dp);
        return ans;
    }
}