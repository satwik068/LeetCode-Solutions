class Solution {
    public boolean canPartition(int[] nums) {
        int totalSum = 0;

        for (int num : nums) {
            totalSum += num;
        }

        // If total sum is odd, equal partition is impossible
        if (totalSum % 2 != 0) {
            return false;
        }

        int target = totalSum / 2;

        // dp[i][j] = can we make sum j using first i elements?
        boolean[][] dp = new boolean[nums.length + 1][target + 1];

        // Sum 0 is always possible
        for (int i = 0; i <= nums.length; i++) {
            dp[i][0] = true;
        }

        for (int i = 1; i <= nums.length; i++) {
            for (int j = 1; j <= target; j++) {

                // Don't take nums[i-1]
                dp[i][j] = dp[i - 1][j];

                // Take nums[i-1] if possible
                if (j >= nums[i - 1]) {
                    dp[i][j] = dp[i][j] ||
                               dp[i - 1][j - nums[i - 1]];
                }
            }
        }

        return dp[nums.length][target];
    }
}