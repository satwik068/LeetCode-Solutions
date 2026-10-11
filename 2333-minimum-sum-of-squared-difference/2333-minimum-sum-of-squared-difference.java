import java.util.*;

class Solution {
    public long minSumSquareDiff(int[] nums1, int[] nums2, int k1, int k2) {
        int n = nums1.length;
        long[] diff = new long[n];
        long max = 0, sum = 0;

        for (int i = 0; i < n; i++) {
            diff[i] = Math.abs(nums1[i] - nums2[i]);
            max = Math.max(max, diff[i]);
            sum += diff[i];
        }

        long k = (long) k1 + k2;

        if (k >= sum) return 0;

        long low = 0, high = max;

        while (low < high) {
            long mid = (low + high) / 2;
            long required = 0;

            for (long d : diff) {
                if (d > mid) required += d - mid;
            }

            if (required <= k) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }

        long remaining = 0;
        for (long d : diff) {
            long reduced = Math.min(d, low);
            remaining += reduced * reduced;
        }

        long operations = k;
        for (long d : diff) {
            if (d > low) operations -= d - low;
        }

        // Use leftover operations to reduce differences at the threshold.
        for (long d : diff) {
            if (operations == 0) break;
            if (d >= low && d > 0) {
                remaining -= low * low;
                remaining += (low - 1) * (low - 1);
                operations--;
            }
        }

        return remaining;
    }
}