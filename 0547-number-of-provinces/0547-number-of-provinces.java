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
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        int count = 0;
        boolean[] visited = new boolean[n];

        for(int i=0; i<n; i++){
            if(!visited[i]){
                count++;
                BFS(i, isConnected, visited);
            }
        }
        return count;
    }
}