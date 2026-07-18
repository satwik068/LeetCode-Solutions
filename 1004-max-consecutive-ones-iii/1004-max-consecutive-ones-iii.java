class Solution {
    public int longestOnes(int[] nums, int k) {
        int zcount = 0;
        int l = 0;
        int r = 0;
        int max = 0;
        while(r<nums.length){
            
            if(nums[r]==0){
                zcount++;
            }
            while(zcount>k){
                if(nums[l]==0){
                    zcount--;
                }
                l++;
            }
            max = Math.max(max, r-l+1);
            r++;
    
        }
        return max;

    }
}