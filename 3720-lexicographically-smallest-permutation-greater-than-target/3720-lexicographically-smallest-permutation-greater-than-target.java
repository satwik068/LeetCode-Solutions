class Solution {
    public String lexGreaterPermutation(String s, String target) {
        int n = s.length();

        int[] count = new int[26];

        // Count characters of s
        for (char c : s.toCharArray()) {
            count[c - 'a']++;
        }

        // Try changing target from right to left
        for (int i = n - 1; i >= 0; i--) {

            // We want target[0 ... i-1] to remain the same.
            int[] remaining = count.clone();

            boolean possible = true;

            // Use characters needed for target[0 ... i-1]
            for (int j = 0; j < i; j++) {
                int idx = target.charAt(j) - 'a';

                remaining[idx]--;

                if (remaining[idx] < 0) {
                    possible = false;
                    break;
                }
            }

            if (!possible) {
                continue;
            }

            // Find smallest character > target[i]
            int current = target.charAt(i) - 'a';

            for (int c = current + 1; c < 26; c++) {

                if (remaining[c] > 0) {

                    StringBuilder ans = new StringBuilder();

                    // Same prefix as target
                    ans.append(target, 0, i);

                    // Make it strictly greater here
                    ans.append((char) ('a' + c));

                    remaining[c]--;

                    // Put remaining characters in sorted order
                    for (int k = 0; k < 26; k++) {
                        while (remaining[k] > 0) {
                            ans.append((char) ('a' + k));
                            remaining[k]--;
                        }
                    }

                    return ans.toString();
                }
            }
        }

        return "";
    }
}