class Solution {
    public void moveZeroes(int[] nums) {
        int n = nums.length;
        int i=0;
        while(i<n){
            if(nums[i]==0){
                int j=i+1;
                while (j < n && nums[j] == 0)
                    j++;

                if (j == n)
                    break;

                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
            }
            i++;
        }


        
    }
}