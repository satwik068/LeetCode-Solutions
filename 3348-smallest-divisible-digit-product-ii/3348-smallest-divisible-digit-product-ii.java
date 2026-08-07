class Solution {
    public String smallestNumber(String num, long t) {
        // Step 1: Factorize t into prime factors 2, 3, 5, 7
        long tempT = t;
        int[] counts = new int[10];
        int[] primes = {2, 3, 5, 7};
        for (int p : primes) {
            while (tempT % p == 0) {
                counts[p]++;
                tempT /= p;
            }
        }

        // If t has prime factors > 7, it's impossible to form the product
        if (tempT > 1) {
            return "-1";
        }

        int n = num.length();
        int firstZero = num.indexOf('0');
        int limit = (firstZero != -1) ? firstZero : n;

        // Track required factors after prefix matching
        int[][] prefixReqs = new int[limit + 1][10];
        prefixReqs[0][2] = counts[2];
        prefixReqs[0][3] = counts[3];
        prefixReqs[0][5] = counts[5];
        prefixReqs[0][7] = counts[7];

        int[][] digitFactors = new int[10][10];
        digitFactors[2][2] = 1;
        digitFactors[3][3] = 1;
        digitFactors[4][2] = 2;
        digitFactors[5][5] = 1;
        digitFactors[6][2] = 1; digitFactors[6][3] = 1;
        digitFactors[7][7] = 1;
        digitFactors[8][2] = 3;
        digitFactors[9][3] = 2;

        for (int i = 0; i < limit; i++) {
            int d = num.charAt(i) - '0';
            for (int p : primes) {
                prefixReqs[i + 1][p] = prefixReqs[i][p] - digitFactors[d][p];
            }
        }

        // Check if num itself is valid
        if (firstZero == -1 && getMinDigits(prefixReqs[n][2], prefixReqs[n][3], prefixReqs[n][5], prefixReqs[n][7]) == 0) {
            return num;
        }

        // Step 2: Try changing digit at index i to a larger digit
        for (int i = limit; i >= 0; i--) {
            if (i == n) continue;

            int c2 = prefixReqs[i][2];
            int c3 = prefixReqs[i][3];
            int c5 = prefixReqs[i][5];
            int c7 = prefixReqs[i][7];

            int startDigit = (i < limit) ? (num.charAt(i) - '0' + 1) : 1;

            for (int d = startDigit; d <= 9; d++) {
                int remC2 = c2 - digitFactors[d][2];
                int remC3 = c3 - digitFactors[d][3];
                int remC5 = c5 - digitFactors[d][5];
                int remC7 = c7 - digitFactors[d][7];

                int remLen = n - 1 - i;
                if (getMinDigits(remC2, remC3, remC5, remC7) <= remLen) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(num, 0, i).append(d);
                    sb.append(getSuffix(remC2, remC3, remC5, remC7, remLen));
                    return sb.toString();
                }
            }
        }

        // Step 3: Expand length if same length is impossible
        int minNeeded = getMinDigits(counts[2], counts[3], counts[5], counts[7]);
        int targetLen = Math.max(n + 1, minNeeded);
        return getSuffix(counts[2], counts[3], counts[5], counts[7], targetLen);
    }

    private int getMinDigits(int c2, int c3, int c5, int c7) {
        c2 = Math.max(0, c2);
        c3 = Math.max(0, c3);
        c5 = Math.max(0, c5);
        c7 = Math.max(0, c7);

        int d9 = c3 / 2, r3 = c3 % 2;
        int d8 = c2 / 3, r2 = c2 % 3;

        int d6 = 0;
        if (r3 == 1 && r2 == 1) {
            d6 = 1; r3 = 0; r2 = 0;
        } else if (r3 == 1 && r2 == 2) {
            d6 = 1; r3 = 0; r2 = 1;
        }

        int d4 = r2 / 2;
        r2 %= 2;

        return d9 + d8 + d6 + d4 + r3 + r2 + c5 + c7;
    }

    private String getSuffix(int c2, int c3, int c5, int c7, int targetLen) {
        c2 = Math.max(0, c2);
        c3 = Math.max(0, c3);
        c5 = Math.max(0, c5);
        c7 = Math.max(0, c7);

        int minLen = getMinDigits(c2, c3, c5, c7);
        int ones = targetLen - minLen;

        int d9 = c3 / 2, r3 = c3 % 2;
        int d8 = c2 / 3, r2 = c2 % 3;

        int d6 = 0;
        if (r3 == 1 && r2 == 1) {
            d6 = 1; r3 = 0; r2 = 0;
        } else if (r3 == 1 && r2 == 2) {
            d6 = 1; r3 = 0; r2 = 1;
        }

        int d4 = r2 / 2;
        r2 %= 2;

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < ones; i++) sb.append('1');
        for (int i = 0; i < r2; i++) sb.append('2');
        for (int i = 0; i < r3; i++) sb.append('3');
        for (int i = 0; i < d4; i++) sb.append('4');
        for (int i = 0; i < c5; i++) sb.append('5');
        for (int i = 0; i < d6; i++) sb.append('6');
        for (int i = 0; i < c7; i++) sb.append('7');
        for (int i = 0; i < d8; i++) sb.append('8');
        for (int i = 0; i < d9; i++) sb.append('9');

        return sb.toString();
    }
}