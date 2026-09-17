class Solution {
    public int count(int i, int[] nums, int T, int[][] dp){
        if(i==nums.length){
            if(T==0) return 1;
            else return 0;
        }
        // if(dp[i][T] != -1) return dp[i][T];
        int skip = count(i+1, nums, T+nums[i], dp);
        int pick = count(i+1, nums, T-nums[i], dp);
        return skip + pick;
    }
    public int findTargetSumWays(int[] nums, int target) {
        int t = (target<0)? (-1*target):target;
        int[][] dp = new int[nums.length][t+1];
        for(int[] a:dp){
            Arrays.fill(a, -1);
        }
        int ans = count(0, nums, target, dp);
        return ans;
    }
}