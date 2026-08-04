class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);

        ArrayList<Integer> ans = new ArrayList<>();
        int x = nums[0];
        int i = 0;
        while(i<=n-1){
            if(nums[i]!=x){
                ans.add(x);
                x++;
            }
            else{
                x++;
                i++;
            }
        }
        return ans;

        // ArrayList<Integer> list = new ArrayList<>();
        // int min = Integer.MAX_VALUE;
        // int max = Integer.MIN_VALUE;
        // for (int x : nums) {
        //     min = Math.min(min, x);
        //     max = Math.max(max, x);
        //     list.add(x);
        // }
        // ArrayList<Integer> ans = new ArrayList<>();
        // if(n==(max-min+1)){
        //     return ans;
        // }
        // for(int i=min; i<=max; i++){
        //     if(!list.contains(i)){
        //         ans.add(i);
        //     }
        // }
        // return ans;
    }
}