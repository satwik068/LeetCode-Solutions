class Solution {

    public boolean totaldays(int[] a, int w, int days){
        int count = 0;
        int sum = 0;
        for(int i=0; i<a.length; i++){
            sum += a[i];
            if(sum>w){
                count++;
                sum = a[i];
            }
        }
        count++;
        return count<=days;
    }

    public int shipWithinDays(int[] weights, int days) {
        int min = 0;
        int max = 0;
        for(int i=0; i<weights.length; i++){
            min = Math.max(min, weights[i]);
            max += weights[i];
        }
        int ans = min;
        while(min<=max){
            int mid = min + (max-min)/2;
            if(totaldays(weights, mid, days)){
                ans = mid;
                max = mid-1;
            }
            else{
                min = mid+1;
            }
        }
        return ans;
    }
}