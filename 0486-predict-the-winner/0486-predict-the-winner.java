class Solution {
    public int fnc(int[] nums, int s, int e){
        if(s==e){
            return nums[s];
        }
        return Math.max(nums[s]-fnc(nums, s+1, e), nums[e]-fnc(nums, s, e-1));
    }
    public boolean predictTheWinner(int[] nums) {
        return fnc(nums, 0, nums.length-1)>=0;
    }
}