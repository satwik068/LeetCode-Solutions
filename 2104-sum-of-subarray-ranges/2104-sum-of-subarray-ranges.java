class Solution {

    public int[] nse(int[] arr){
        int n = arr.length;
        int[] r = new int[n];
        Stack<Integer> st = new Stack<>();
        for(int i=n-1; i>=0; i--){
            while(!st.isEmpty() && arr[i]<=arr[st.peek()]){
                st.pop();
            }
            if(st.isEmpty()) r[i] = n;
            else r[i] = st.peek();
            st.push(i);
        }
        return r;
    }
    public int[] nge(int[] arr){
        int n = arr.length;
        int[] r = new int[n];
        Stack<Integer> st = new Stack<>();
        for(int i=n-1; i>=0; i--){
            while(!st.isEmpty() && arr[i]>=arr[st.peek()]){
                st.pop();
            }
            if(st.isEmpty()) r[i] = n;
            else r[i] = st.peek();
            st.push(i);
        }
        return r;
    }
    public int[] pse(int[] arr){
        int n = arr.length;
        int[] l = new int[n];
        Stack<Integer> st = new Stack<>();
        for(int i=0; i<n; i++){
            while(!st.isEmpty() && arr[i]<arr[st.peek()]){
                st.pop();
            }
            if(st.isEmpty()) l[i] = -1;
            else l[i] = st.peek();
            st.push(i);
        }
        return l;
    }
    public int[] pge(int[] arr){
        int n = arr.length;
        int[] l = new int[n];
        Stack<Integer> st = new Stack<>();
        for(int i=0; i<n; i++){
            while(!st.isEmpty() && arr[i]>arr[st.peek()]){
                st.pop();
            }
            if(st.isEmpty()) l[i] = -1;
            else l[i] = st.peek();
            st.push(i);
        }
        return l;
    }
    public long subArrayRanges(int[] nums) {
        int n = nums.length;
        int[] nse = nse(nums);
        int[] nge = nge(nums);
        int[] pse = pse(nums);
        int[] pge = pge(nums);


        long sum = 0;
        for(int i=0; i<n; i++){
            int lsmaller = i - pse[i];
            int rsmaller = nse[i] - i;
            int lgreater = i - pge[i];
            int rgreater = nge[i] - i;

            long freq1 = lsmaller * rsmaller * 1L;
            long val1 = (long)(freq1 * nums[i]);

            long freq2 = lgreater * rgreater * 1L;
            long val2 = (long)(freq2 * nums[i]);
            sum = sum + (val2-val1);
        }
        return sum;

    }
}