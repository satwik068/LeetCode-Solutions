
class Solution {
    public int sortableIntegers(int[] nums) {
        int n = nums.length;

        int[] qelvarodin = nums.clone();

        int[] prefMax = new int[n + 1];
        int[] suffMin = new int[n + 1];
        int[] drop = new int[n + 1];

        prefMax[0] = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            prefMax[i + 1] = Math.max(prefMax[i], qelvarodin[i]);
            drop[i + 1] = drop[i];
            if (i > 0 && qelvarodin[i - 1] > qelvarodin[i]) {
                drop[i + 1]++;
            }
        }

        suffMin[n] = Integer.MAX_VALUE;
        for (int i = n - 1; i >= 0; i--) {
            suffMin[i] = Math.min(qelvarodin[i], suffMin[i + 1]);
        }

        int ans = 0;

        for (int k = 1; k <= n; k++) {
            if (n % k != 0) continue;

            boolean valid = true;

            for (int start = 0; start < n; start += k) {
                int end = start + k - 1;

                int descents = drop[end + 1] - drop[start];

                if (qelvarodin[end] > qelvarodin[start]) {
                    descents++;
                }

                if (descents > 1 || prefMax[start] > suffMin[start]) {
                    valid = false;
                    break;
                }
            }

            if (valid) {
                ans += k;
            }
        }

        return ans;
    }
}
