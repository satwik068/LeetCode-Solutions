class Solution {
    public int sumSubarrayMins(int[] arr) {
        int n = arr.length;
        Stack<Integer> st = new Stack<>();
        int[] r = new int[n];
        int[] l = new int[n];

        for(int i=n-1; i>=0; i--){
            while(!st.isEmpty() && arr[i]<=arr[st.peek()]){
                st.pop();
            }
            if(st.isEmpty()) r[i] = n;
            else r[i] = st.peek();
            st.push(i);
        }

        while(!st.isEmpty()) st.pop();

        for(int i=0; i<n; i++){
            while(!st.isEmpty() && arr[i]<arr[st.peek()]){
                st.pop();
            }
            if(st.isEmpty()) l[i] = -1;
            else l[i] = st.peek();
            st.push(i);
        }


        int sum = 0;
        int mod = (int)(Math.pow(10, 9)+7);
        for(int i=0; i<n; i++){
            int left = i - l[i];
            int right = r[i] - i;
            long freq = left * right * 1L;
            int val = (int)((freq * arr[i]) % mod);
            sum = (sum + val) % mod;
        }
        return sum;

    }
}