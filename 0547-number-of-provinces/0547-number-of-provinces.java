class Solution {
    public void BFS(int i, int[][] isConnected, boolean[] visited){
        Queue<Integer> q = new LinkedList<>();
        q.add(i);
        visited[i] = true;
        while(q.size()!=0){
            int num = q.poll();
            for(int j=0; j<isConnected.length; j++){
                if(!visited[j] && isConnected[num][j]==1){
                    visited[j] = true;
                    q.add(j);
                }
            }
        }
    }

    public void DFS(int i, int[][] isConnected, boolean[] vis){
        vis[i] = true;
        for(int j=0; j<isConnected.length; j++){
            if(!vis[j] && isConnected[i][j]==1){
                DFS(j, isConnected, vis);
            }
        }
    }
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        int count = 0;
        boolean[] visited = new boolean[n];

        for(int i=0; i<n; i++){
            if(!visited[i]){
                count++;
                // BFS(i, isConnected, visited);
                DFS(i, isConnected, visited);
            }
        }
        return count;
    }
}