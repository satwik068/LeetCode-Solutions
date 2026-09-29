class Solution {
    int m, n;
    char[][] grid;
    Boolean[][][] dp;

    public boolean hasValidPath(char[][] grid) {
        this.grid = grid;
        m = grid.length;
        n = grid[0].length;

        // Path length must be even
        if ((m + n - 1) % 2 != 0) {
            return false;
        }

        // Start must be '(' and end must be ')'
        if (grid[0][0] != '(' || grid[m - 1][n - 1] != ')') {
            return false;
        }

        dp = new Boolean[m][n][m + n];

        return dfs(0, 0, 0);
    }

    private boolean dfs(int r, int c, int balance) {
        // Update balance based on current character
        if (grid[r][c] == '(') {
            balance++;
        } else {
            balance--;
        }

        // Balance can never become negative
        if (balance < 0) {
            return false;
        }

        // Remaining cells cannot provide enough ')' to close balance
        int remaining = (m - 1 - r) + (n - 1 - c);
        if (balance > remaining) {
            return false;
        }

        // Destination
        if (r == m - 1 && c == n - 1) {
            return balance == 0;
        }

        if (dp[r][c][balance] != null) {
            return dp[r][c][balance];
        }

        boolean result = false;

        // Move down
        if (r + 1 < m) {
            result = dfs(r + 1, c, balance);
        }

        // Move right
        if (!result && c + 1 < n) {
            result = dfs(r, c + 1, balance);
        }

        return dp[r][c][balance] = result;
    }
}