class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int[] r = new int[n];
        int[] l = new int[n];

        int max = 0;
        for(int i=0; i<n; i++){
            if(height[max]>height[i]){
                l[i] = height[max];
            }
            else{
                l[i] = -1;
                max = i;
            }
        }
        max = n-1;
        for(int i=n-1; i>=0; i--){
            if(height[max]>height[i]){
                r[i] = height[max];
            }
            else{
                r[i] = -1;
                max = i;
            }
        }

        int[] arr = new int[n];
        int sum = 0;
        for(int i=0; i<n; i++){
            int min = Math.min(r[i], l[i]);
            arr[i] = (min==-1)? 0:min-height[i];
            sum += arr[i];
        }
        return sum;

    }
}