class Solution {

    public int digsum(int n){
        int sum = 0;
        while(n>0){
            sum += n%10;
            n /= 10;
        }
        return sum;
    }

    public int digproduct(int n){
        int pro = 1;
        while(n>0){
            pro *= n%10;
            n /= 10;
        }
        return pro;
    }
    public boolean checkDivisibility(int n) {
        int sum = digsum(n) + digproduct(n);
        return n%sum==0;
    }
}