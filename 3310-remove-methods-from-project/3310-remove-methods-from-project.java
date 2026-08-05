class Solution {

    public void dfs(int node, List<List<Integer>> graph, boolean[] suspicious){
        suspicious[node] = true;

        for(int num: graph.get(node)){
            if(!suspicious[num]){
                dfs(num, graph, suspicious);
            }
        } 
    }

    public List<Integer> remainingMethods(int n, int k, int[][] invocations) {
        List<List<Integer>> graph = new ArrayList<>();

        for(int i=0; i<n; i++){
            graph.add(new ArrayList<>());
        }

        for(int[] edge:invocations){
            graph.get(edge[0]).add(edge[1]);
        }

        boolean[] suspicious = new boolean[n];
        dfs(k, graph, suspicious);

        List<Integer> ans = new ArrayList<>();
        for(int[] edge:invocations){
            int u = edge[0];
            int v = edge[1];
            if(!suspicious[u] && suspicious[v]){
                for(int i=0; i<n; i++){
                    ans.add(i);
                }
                return ans;
            }
        }
        for(int i=0; i<n; i++){
            if(!suspicious[i]){
                ans.add(i);
            }
        }
        return ans;

    }
}