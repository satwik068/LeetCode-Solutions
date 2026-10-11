class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        boolean[] vis = new boolean[rooms.size()];
        Queue<Integer> q = new LinkedList<>();
        q.add(0);
        vis[0] = true;

        while(!q.isEmpty()){
            int num = q.poll();
            for(int i:rooms.get(num)){
                if(!vis[i]){
                    vis[i] = true;
                    q.add(i);
                }
            }
        }
        for(int i=0; i<rooms.size(); i++){
            if(!vis[i]) return false;
        }
        return true;

    }
}