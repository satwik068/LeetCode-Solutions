class Solution {
    public int majorityElement(int[] nums) {
        int count = 1;
        int cur = nums[0];
        for(int i=1; i<nums.length; i++){
            if(cur==nums[i]) count++;
            else{
                if(count>0) count--;
                else{
                    cur = nums[i];
                    count++;
                }
                
            }
        }
        return cur;
        
    }
}