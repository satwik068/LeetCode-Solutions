class Solution {

    public void reverse(int[] nums, int start, int end){
        while(start<=end){
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

    public void nextPermutation(int[] nums) {
        int i = nums.length-1;
        if(i==0) return;
        int bp = 0;
        while(i>0){
            if(nums[i-1]<nums[i]){
                bp = i-1;
                break;
            }
            else{
                i--;
            }
        }

        if(i==0){
            reverse(nums, 0, nums.length-1);
            return;
        }
        i = nums.length-1;
        while(i>=bp){
            if(nums[i]>nums[bp]){
                int temp = nums[i];
                nums[i] = nums[bp];
                nums[bp] = temp;
                break;
            }
            else i--;
        }

        if(bp+1 != nums.length-1){
            reverse(nums, bp+1, nums.length-1);
        }




    }
}