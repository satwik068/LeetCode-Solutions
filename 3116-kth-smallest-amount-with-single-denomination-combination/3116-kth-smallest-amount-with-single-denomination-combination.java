import java.util.*;

class Solution {
    long lcm(long a, long b) {
        return a / gcd(a, b) * b;
    }

    long gcd(long a, long b) {
        while (b != 0) {
            long t = a % b;
            a = b;
            b = t;
        }
        return a;
    }

    long count(long x, int[] coins) {
        int n = coins.length;
        long ans = 0;

        for (int mask = 1; mask < (1 << n); mask++) {
            long multiple = 1;
            int bits = 0;
            boolean valid = true;

            for (int i = 0; i < n; i++) {
                if ((mask & (1 << i)) != 0) {
                    bits++;
                    multiple = lcm(multiple, coins[i]);

                    if (multiple > x) {
                        valid = false;
                        break;
                    }
                }
            }

            if (valid) {
                long cnt = x / multiple;

                if ((bits & 1) == 1)
                    ans += cnt;
                else
                    ans -= cnt;
            }
        }

        return ans;
    }

    public long findKthSmallest(int[] coins, int k) {
        long low = 1;
        long high = (long) k * Arrays.stream(coins).min().getAsInt();

        while (low < high) {
            long mid = low + (high - low) / 2;

            if (count(mid, coins) >= k)
                high = mid;
            else
                low = mid + 1;
        }

        return low;
    }
}