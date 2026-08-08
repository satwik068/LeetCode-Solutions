class Solution {
    public int[] validSequence(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();

        // suf[i] = first unmatched position of word2
        // when matching word2 from right using word1[i...]
        int[] suf = new int[n + 1];
        int j = m - 1;

        for (int i = n - 1; i >= 0; i--) {
            if (j >= 0 && word1.charAt(i) == word2.charAt(j)) {
                j--;
            }
            suf[i] = j + 1;
        }

        int[] ans = new int[m];
        int k = 0;
        boolean usedMismatch = false;

        for (int i = 0; i < n && k < m; i++) {

            // Exact match: always take it
            if (word1.charAt(i) == word2.charAt(k)) {
                ans[k++] = i;
            }

            // Use the one allowed mismatch
            else if (!usedMismatch) {

                // Remaining word2 after using i must be
                // completely matched by word1[i+1...]
                int remaining = m - k - 1;

                if (m - suf[i + 1] >= remaining) {
                    ans[k++] = i;
                    usedMismatch = true;
                }
            }
        }

        return k == m ? ans : new int[0];
    }
}