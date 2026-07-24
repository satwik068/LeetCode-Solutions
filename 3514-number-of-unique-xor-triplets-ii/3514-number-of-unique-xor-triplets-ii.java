import java.util.*;

class Solution {
    public int uniqueXorTriplets(int[] nums) {
        int n = nums.length;

        if (n == 1) return 1;

        HashSet<Integer> pairXor = new HashSet<>();

        // Store all unique XORs of two different elements
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                pairXor.add(nums[i] ^ nums[j]);
            }
        }

        BitSet ans = new BitSet(2048);

        // Triplets where all three indices are same
        for (int num : nums) {
            ans.set(num);
        }

        // pairXor ^ third element
        for (int x : pairXor) {
            for (int num : nums) {
                ans.set(x ^ num);
            }
        }

        return ans.cardinality();
    }
}