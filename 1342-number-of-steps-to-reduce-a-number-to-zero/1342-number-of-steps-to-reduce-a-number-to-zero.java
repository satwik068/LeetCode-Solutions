class Solution {
    public int numberOfSteps(int num) {
        return helper(num, 0);
    }
    public int helper(int n, int step){
        if(n==0) return step;
        if(n%2==0) return helper(n/2, step+1);
        return helper(n-1, step+1);
    }
}