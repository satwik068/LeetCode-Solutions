class Solution {
    public int longestSubarray(int[] nums) {
        int max = 0;
        int l=0;
        int r=0;
        int count=0;
        while(r<nums.length){
            if(nums[r]==0) count++;
            while(count>1){
                if(nums[l]==0) count--;
                l++;
            }
            max = Math.max(max, r-l+1);
            r++;
        }
        return max-1;
    }
}