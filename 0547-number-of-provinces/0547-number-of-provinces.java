class Solution {
    public int findCircleNum(int[][] isConnected) {
        //adj list is given
        int n = isConnected.length;
        boolean [] vis = new boolean[n];
        int ans = 0;
        for(int i = 0; i<n; i++){
            if(!vis[i]){
                ans++;
                dfs(i, vis, isConnected);
            }
        }
        return ans;
    }
    public void dfs(int node, boolean vis[], int[][] isConnected){
        vis[node] = true;
        for(int who = 0; who<isConnected.length; who++){
            if(isConnected[node][who] == 1 && !vis[who]){
                dfs(who, vis, isConnected);
            }
        }
    }
}