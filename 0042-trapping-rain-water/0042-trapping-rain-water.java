class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int[] r = new int[n];
        int[] l = new int[n];

        l[0] = height[0];
        r[n-1] = height[n-1];
        for(int i=1; i<n; i++){
            l[i] = Math.max(l[i-1], height[i]);
        }
        for(int i=n-2; i>=0; i--){
            r[i] = Math.max(r[i+1], height[i]);
        }

        int[] arr = new int[n];
        int sum = 0;
        for(int i=0; i<n; i++){
            int min = Math.min(r[i], l[i]);
            arr[i] = min-height[i];
            sum += arr[i];
        }
        return sum;

    }
}