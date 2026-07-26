class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] a = new int[nums1.length+nums2.length];
        System.arraycopy(nums1, 0, a, 0, nums1.length);
        System.arraycopy(nums2, 0, a, nums1.length, nums2.length);

        Arrays.sort(a);
        int mid = a.length/2;
        if(a.length%2!=0){
            return a[mid];
        }
        else{
            double ans = (double)(a[mid]+a[mid-1])/2; 
            return ans;
        }

    }
}