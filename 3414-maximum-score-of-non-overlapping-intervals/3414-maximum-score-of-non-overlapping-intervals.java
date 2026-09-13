import java.util.*;

class Solution {
    public int[] maximumWeight(List<List<Integer>> intervals) {
        int n = intervals.size();

        // [start, end, weight, originalIndex]
        long[][] a = new long[n][4];

        for (int i = 0; i < n; i++) {
            a[i][0] = intervals.get(i).get(0);
            a[i][1] = intervals.get(i).get(1);
            a[i][2] = intervals.get(i).get(2);
            a[i][3] = i;
        }

        // Sort by start time
        Arrays.sort(a, Comparator.comparingLong(x -> x[0]));

        long[] starts = new long[n];
        for (int i = 0; i < n; i++) {
            starts[i] = a[i][0];
        }

        // dp[i][k] = best answer starting from i
        // when we can still select at most k intervals.
        State[][] dp = new State[n + 1][5];

        for (int k = 0; k <= 4; k++) {
            dp[n][k] = new State(0, new int[0]);
        }

        for (int i = n - 1; i >= 0; i--) {
            dp[i][0] = new State(0, new int[0]);

            for (int k = 1; k <= 4; k++) {

                // Option 1: skip interval i
                State skip = dp[i + 1][k];

                // Option 2: take interval i
                int next = upperBound(starts, a[i][1]);

                State rest = dp[next][k - 1];

                int[] indices = new int[rest.indices.length + 1];
                indices[0] = (int) a[i][3];
                System.arraycopy(
                    rest.indices, 0,
                    indices, 1,
                    rest.indices.length
                );

                Arrays.sort(indices);

                State take = new State(
                    a[i][2] + rest.weight,
                    indices
                );

                dp[i][k] = better(take, skip);
            }
        }

        return dp[0][4].indices;
    }

    // First index whose start > end.
    // Intervals are inclusive, so start == end overlaps.
    private int upperBound(long[] starts, long end) {
        int lo = 0, hi = starts.length;

        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;

            if (starts[mid] > end) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }

        return lo;
    }

    // Higher weight wins.
    // If equal, lexicographically smaller index array wins.
    private State better(State a, State b) {
        if (a.weight != b.weight) {
            return a.weight > b.weight ? a : b;
        }

        int len = Math.min(a.indices.length, b.indices.length);

        for (int i = 0; i < len; i++) {
            if (a.indices[i] != b.indices[i]) {
                return a.indices[i] < b.indices[i] ? a : b;
            }
        }

        return a.indices.length < b.indices.length ? a : b;
    }

    static class State {
        long weight;
        int[] indices;

        State(long weight, int[] indices) {
            this.weight = weight;
            this.indices = indices;
        }
    }
}