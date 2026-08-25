class Solution {
    public int missingMultiple(int[] nums, int k) {
        List<Integer> list = new ArrayList<>();

        int n = nums.length;
        for(int i=0; i<n; i++){
            list.add(nums[i]);
        }
        
        for(int i=1; i<=n+1; i++){
            if(!list.contains(k*i)){
                return k*i;
            }
        }
        return -1;
    }
}