class Solution {

    public void main(String[] args){
        int[] nums = {12,345,2,6,7896};
        System.out.println(findNumbers(nums));
    }

    public int findNumbers(int[] nums) {
        int count = 0;
        for(int x:nums){
            if(even(x)) count++;
        }
        return count;
    }

    boolean even(int x){
        int digit = digits(x);
        return digit%2 == 0;
    }

    int digits(int x){
        if(x<0) x*=-1;
        return (int)(Math.log10(x))+1;
    }
}