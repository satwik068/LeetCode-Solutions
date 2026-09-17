class Solution {
    static int sum;
    public int count(int total, int i, int[] nums, int T, int[][] dp){
        if(i==nums.length){
            if(total==T) return 1;
            else return 0;
        }
        if(dp[i][total+sum] != -1) return dp[i][total+sum];
        int skip = count(total+nums[i], i+1, nums, T, dp);
        int pick = count(total-nums[i], i+1, nums, T, dp);
        return dp[i][total+sum] = skip + pick;
    }
    public int findTargetSumWays(int[] nums, int target) {
        sum = 0;
        for(int i:nums){
            sum += i;
        }
        int[][] dp = new int[nums.length][2*sum+1];
        for(int[] a:dp){
            Arrays.fill(a, -1);
        }
        int ans = count(0, 0, nums, target, dp);
        return ans;
    }
}