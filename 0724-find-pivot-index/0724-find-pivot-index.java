class Solution {
    public int pivotIndex(int[] nums) {
        int tsum = 0;
        for(int i=0; i<nums.length; i++){
            tsum += nums[i];
        }
        int lsum = 0;
        for(int i=0; i<nums.length; i++){
            int rsum = tsum - lsum - nums[i];
            if(lsum==rsum) return i;
            lsum += nums[i];
        }
        return -1;

    }
}