class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        int i=0; 
        Arrays.sort(nums);

        while(i<nums.length-2){
            if (i > 0 && nums[i] == nums[i - 1]) {
                i++;
                continue;
            }

            int left = i+1;
            int right = nums.length-1;
            while(left<right){
                int sum = nums[i]+nums[left]+nums[right];
                if(sum==0){
                    ans.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    left++;
                    right--;

                    while (left < right && nums[left] == nums[left - 1])
                        left++;

                    while (left < right && nums[right] == nums[right + 1])
                        right--;
                }
                else if(sum<0){
                    left++;
                }
                else{
                    right--;
                }
            }
            i++;

        }
        return ans;

    }
}