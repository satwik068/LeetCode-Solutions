class Solution {
    public String lexPalindromicPermutation(String s, String target) {

        int n = s.length();
        int[] cnt = new int[26];

        // Count characters
        for (char c : s.toCharArray()) {
            cnt[c - 'a']++;
        }

        // Check whether palindrome is possible
        int odd = 0;
        char mid = 0;

        for (int i = 0; i < 26; i++) {
            if (cnt[i] % 2 == 1) {
                odd++;
                mid = (char) ('a' + i);
            }
        }

        if (odd > 1) {
            return "";
        }

        /*
         * cnt now represents the number of characters
         * available for BOTH halves.
         *
         * We work with pairs, so divide by 2.
         */
        int[] half = new int[26];

        for (int i = 0; i < 26; i++) {
            half[i] = cnt[i] / 2;
        }

        int m = n / 2;

        /*
         * First try making the left half equal to
         * target's left half.
         */
        for (int i = 0; i < m; i++) {
            half[target.charAt(i) - 'a']--;
        }

        // Check if target's left half can actually be formed
        boolean possible = true;

        for (int x : half) {
            if (x < 0) {
                possible = false;
                break;
            }
        }

        /*
         * If we can make the same left half,
         * maybe the resulting palindrome is already
         * greater than target because of the right half.
         */
        if (possible) {

            String left = target.substring(0, m);

            StringBuilder right = new StringBuilder(left)
                    .reverse();

            String candidate;

            if (n % 2 == 1) {
                candidate = left + mid + right;
            } else {
                candidate = left + right;
            }

            if (candidate.compareTo(target) > 0) {
                return candidate;
            }
        }

        /*
         * We couldn't get a valid answer by keeping
         * the complete left half equal.
         *
         * Start from the rightmost position and try
         * increasing it.
         */
        for (int i = m - 1; i >= 0; i--) {

            // Restore the character used at position i
            half[target.charAt(i) - 'a']++;

            /*
             * Check if positions [0 ... i-1] can still
             * remain equal to target.
             */
            possible = true;

            for (int x : half) {
                if (x < 0) {
                    possible = false;
                    break;
                }
            }

            if (!possible) {
                continue;
            }

            int current = target.charAt(i) - 'a';

            // Try the smallest character greater than target[i]
            for (int next = current + 1; next < 26; next++) {

                if (half[next] == 0) {
                    continue;
                }

                // Use this character
                half[next]--;

                StringBuilder left = new StringBuilder();

                // Prefix equal to target
                for (int j = 0; j < i; j++) {
                    left.append(target.charAt(j));
                }

                // Increased character
                left.append((char) ('a' + next));

                /*
                 * Fill remaining positions with the
                 * smallest possible characters.
                 */
                for (int c = 0; c < 26; c++) {
                    while (half[c] > 0) {
                        left.append((char) ('a' + c));
                        half[c]--;
                    }
                }

                String leftPart = left.toString();

                StringBuilder right = new StringBuilder(leftPart)
                        .reverse();

                String answer;

                if (n % 2 == 1) {
                    answer = leftPart + mid + right;
                } else {
                    answer = leftPart + right;
                }

                return answer;
            }

            /*
             * If no larger character worked, restore
             * the available counts before moving further left.
             */
            for (int c = 0; c < 26; c++) {
                if (c != target.charAt(i) - 'a') {
                    // Nothing to restore here because the
                    // loop only permanently consumes when returning.
                }
            }
        }

        return "";
    }
}