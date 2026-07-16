class Solution {

    public int GCD(int a, int b){
        if(b==0) return a;
        return GCD(b, a%b);
    }

    public long gcdSum(int[] nums) {
        int maxi = Integer.MIN_VALUE;
        int[] prefix = new int[nums.length];

        for(int i=0; i<nums.length; i++){
            maxi = Math.max(maxi, nums[i]);
            prefix[i] = GCD(nums[i], maxi);
        }

        Arrays.sort(prefix);

        long sum = 0;
        int i=0;
        int j=prefix.length-1;
        while(i<j){
            sum += GCD(prefix[i], prefix[j]);
            i++;
            j--;
        }
        return sum;
    }
}