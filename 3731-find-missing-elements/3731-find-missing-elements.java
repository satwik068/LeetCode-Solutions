class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        int n = nums.length;
        ArrayList<Integer> list = new ArrayList<>();
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int x : nums) {
            min = Math.min(min, x);
            max = Math.max(max, x);
            list.add(x);
        }
        ArrayList<Integer> ans = new ArrayList<>();
        if(n==(max-min+1)){
            return ans;
        }
        for(int i=min; i<=max; i++){
            if(!list.contains(i)){
                ans.add(i);
            }
        }
        return ans;
    }
}