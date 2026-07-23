class Solution {
    public int uniqueXorTriplets(int[] nums) {
        int n = nums.length;
        if(n<=2) return n;
        int count = 1;
        while(count<=n){
            count<<=1;
        }
        return count;
    }
}