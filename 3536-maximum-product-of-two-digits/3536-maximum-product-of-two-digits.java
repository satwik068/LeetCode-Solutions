class Solution {
    public int maxProduct(int n) {
        int max1 = n%10;
        n /= 10;
        int max2 = n%10;
        n/=10;
        if(max2>max1){
            int temp = max1;
            max1 = max2;
            max2 = temp;
        }
        while(n>0){
            int num = n%10;
            if(num>max1){
                max2 = max1;
                max1 = num;
                n/=10;
            }
            else if(num>max2){
                max2 = num;
                n/=10;
            }
            else{
                n/=10;

            }
        }
        return max1*max2;
    }
}