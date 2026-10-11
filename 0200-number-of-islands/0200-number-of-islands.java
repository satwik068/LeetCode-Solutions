class Solution {
    public void BFS(int[] a, char[][] grid){
        int m = grid.length;
        int n = grid[0].length;
        Queue<int[]> q = new LinkedList<>();
        q.add(a);
        grid[a[0]][a[1]] = '0';
        while(!q.isEmpty()){
            int[] num = q.poll();
            int i = num[0];
            int j = num[1];
            if(i>0 && grid[i-1][j]=='1'){
                grid[i-1][j] = '0';
                q.add(new int[]{i-1, j});
            }
            if(j>0 && grid[i][j-1]=='1'){
                grid[i][j-1] = '0';
                q.add(new int[]{i, j-1});
            }
            if(i<m-1 && grid[i+1][j]=='1'){
                grid[i+1][j] = '0';
                q.add(new int[]{i+1, j});
            }
            if(j<n-1 && grid[i][j+1]=='1'){
                grid[i][j+1] = '0';
                q.add(new int[]{i, j+1});
            }
            
        }
    }

    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int count = 0;

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j]=='1'){
                    count++;
                    BFS(new int[]{i, j}, grid);
                }
            }
        }
        return count;
        
    }
}