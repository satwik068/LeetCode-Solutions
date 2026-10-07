class Solution {
    public int minAddToMakeValid(String s) {
        int open = 0;   // unmatched '('
        int add = 0;    // '(' needed for unmatched ')'

        for (char ch : s.toCharArray()) {
            if (ch == '(') {
                open++;
            } else {
                if (open > 0) {
                    open--;   // match this ')' with an existing '('
                } else {
                    add++;    // need to add '(' before this ')'
                }
            }
        }

        // 'open' closing parentheses are still needed
        return add + open;
    }
}