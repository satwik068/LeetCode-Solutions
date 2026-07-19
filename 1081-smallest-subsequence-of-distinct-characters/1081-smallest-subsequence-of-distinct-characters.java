class Solution {
    public String smallestSubsequence(String s) {

        int[] last = new int[26];
        for (int i = 0; i < s.length(); i++) {
            last[s.charAt(i) - 'a'] = i;
        }

        
        boolean[] visited = new boolean[26];
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            // Skip if already included
            if (visited[c - 'a']) {
                continue;
            }

            // Remove larger characters if they appear later
            while (!stack.isEmpty()
                    && stack.peek() > c
                    && last[stack.peek() - 'a'] > i) {
                visited[stack.pop() - 'a'] = false;
            }

            stack.push(c);
            visited[c - 'a'] = true;
        }

        // Build answer
        StringBuilder ans = new StringBuilder();
        for (char ch : stack) {
            ans.append(ch);
        }

        return ans.toString();
    }
}