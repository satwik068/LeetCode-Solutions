class Solution {
    public int largestRectangleArea(int[] heights) {
        // int n = heights.length;
        // int[] r = new int[n];
        // int[] l = new int[n];

        // Stack<Integer> s = new Stack<>();

        // for(int i=n-1; i>=0; i--){
        //     while(s.size()>0 && heights[i]<=heights[s.peek()]){
        //         s.pop();
        //     }
        //     if(s.empty()) r[i] = n;
        //     else r[i] = s.peek();
        //     s.push(i);
        // }

        // while(s.size()>0) s.pop();

        // for(int i=0; i<n; i++){
        //     while(s.size()>0 && heights[i]<=heights[s.peek()]){
        //         s.pop();
        //     }
        //     if(s.empty()) l[i] = -1;
        //     else l[i] = s.peek();
        //     s.push(i);
        // }

        // int ans = 0;

        // for(int i=0; i<n; i++){
        //     int area = heights[i]*(r[i]-l[i]-1);
        //     ans = Math.max(ans, area);
        // }
        // return ans;

        int n = heights.length;
        int[] r = new int[n];
        int[] l = new int[n];

        Stack<Integer> s = new Stack<>();

        for(int i=n-1; i>=0; i--){
            while(s.size()>0 && heights[i]<=heights[s.peek()]){
                s.pop();
            }
            if(s.isEmpty()) r[i] = n;
            else r[i] = s.peek();
            s.push(i);
        }

        while(!s.isEmpty()) s.pop();

        for(int i=0; i<n; i++){
            while(s.size()>0 && heights[i]<=heights[s.peek()]){
                s.pop();
            }
            if(s.isEmpty()) l[i] = -1;
            else l[i] = s.peek();
            s.push(i);
        }

        int ans = 0;
        for(int i=0; i<n; i++){
            int area = heights[i] * (r[i]-l[i]-1);
            ans = Math.max(ans, area);
        }
        return ans;
    }
}