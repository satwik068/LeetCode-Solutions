class Solution {
    public int maxActiveSectionsAfterTrade(String s) {
        int n = s.length();
        int totalOnes = 0;
        int maxGain = 0;

        int prevZero = -1;
        int i = 0;

        while (i < n) {
            char ch = s.charAt(i);
            int j = i;

            while (j < n && s.charAt(j) == ch) {
                j++;
            }

            int len = j - i;

            if (ch == '1') {
                totalOnes += len;

                // 1-block must be surrounded by 0s
                if (i > 0 && j < n && s.charAt(i - 1) == '0' && s.charAt(j) == '0') {
                    // Length of left 0-block
                    int left = 0;
                    int k = i - 1;
                    while (k >= 0 && s.charAt(k) == '0') {
                        left++;
                        k--;
                    }

                    // Length of right 0-block
                    int right = 0;
                    k = j;
                    while (k < n && s.charAt(k) == '0') {
                        right++;
                        k++;
                    }

                    maxGain = Math.max(maxGain, left + right);
                }
            }

            i = j;
        }

        return totalOnes + maxGain;
    }
}