class Solution {
    public int findPeakElement(int[] nums) {
        // int n = nums.length;
        // if(n==1) return 0;
        // if(nums[0]>nums[1]) return 0;
        // if(nums[n-1]>nums[n-2]) return n-1;
        int start = 0;
        int end = nums.length-1;

        while(start<end){
            int mid = start+(end-start)/2;
            if(nums[mid]>nums[mid+1]){
                end = mid;
            }
            else{
                start = mid+1;
            }
        }
        return start;

    }
}