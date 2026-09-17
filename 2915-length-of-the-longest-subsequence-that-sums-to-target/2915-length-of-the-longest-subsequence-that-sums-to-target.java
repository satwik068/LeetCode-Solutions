class Solution {
    public long count(int i, List<Integer> nums, int T, long[][] dp){
        if(i==nums.size()){
            if(T==0) return 0;
            else return Integer.MIN_VALUE;
        }
        if(dp[i][T] != -1) return dp[i][T];
        long skip = count(i+1, nums, T, dp);
        if(nums.get(i)>T) return dp[i][T] = skip;
        long pick = 1 + count(i+1, nums, T-nums.get(i), dp);
        return dp[i][T] = Math.max(skip, pick);
    }
    public int lengthOfLongestSubsequence(List<Integer> nums, int target) {
        long[][] dp = new long[nums.size()][target+1];
        for(long[] a:dp){
            Arrays.fill(a, -1);
        }
        int ans = (int)count(0, nums, target, dp);
        if(ans<0) return -1;
        return ans;
    }
}