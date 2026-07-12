class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        Stack<Integer> s = new Stack<>();
        int[] ans = new int[nums.length];
        for(int i=2*n-1; i>=0; i--){

            while(s.size()>0 && nums[i%n]>=nums[s.peek()]){
                s.pop();
            }
            if(s.empty()){
                ans[i%n] = -1;
            }
            else{
                ans[i%n] = nums[s.peek()];
            }
            s.push(i%n);
        }
        return ans;
    }
}