class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        
        Stack<Integer> s = new Stack<>();
        int[] a = new int[nums2.length];

        for(int i=nums2.length-1; i>=0; i--){

            while(s.size()>0 && nums2[i]>=nums2[s.peek()]){
                s.pop();
            }

            if(s.empty()){
                a[i] = -1;
            }
            else{
                a[i] = nums2[s.peek()];
            }
            s.push(i);
        }

        int[] ans = new int[nums1.length];
        for(int i=0; i<nums1.length; i++){
            for(int j=0; j<nums2.length; j++){
                if(nums1[i]==nums2[j]){
                    ans[i]=a[j];
                    break;
                }
            }
        }
        return ans;
    }
}