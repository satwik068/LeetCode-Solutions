
class Solution {
    public int countIslands(int[][] grid, int k) {
        int m = grid.length, n = grid[0].length;
        int ans = 0;

        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) continue;

                long sum = 0;
                java.util.Stack<int[]> st = new java.util.Stack<>();
                st.push(new int[]{i, j});

                sum += grid[i][j];
                grid[i][j] = 0;

                while (!st.isEmpty()) {
                    int[] cur = st.pop();

                    for (int d = 0; d < 4; d++) {
                        int x = cur[0] + dx[d];
                        int y = cur[1] + dy[d];

                        if (x >= 0 && x < m &&
                            y >= 0 && y < n &&
                            grid[x][y] > 0) {

                            sum += grid[x][y];
                            grid[x][y] = 0;
                            st.push(new int[]{x, y});
                        }
                    }
                }

                if (sum % k == 0) {
                    ans++;
                }
            }
        }

        return ans;
    }
}
