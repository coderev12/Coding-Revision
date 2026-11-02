PS: https://leetcode.com/problems/number-of-provinces/description/
class Solution {
    public int findCircleNum(int[][] isConnected) {
        int V = isConnected.length;
        boolean[] vis = new boolean[V];
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0;i<V;i++){
            adj.add(new ArrayList<>());
        }
        for(int i = 0;i<isConnected.length;i++){
            for(int j = 0;j<isConnected.length;j++){
                int n1 = isConnected[i][j];
                if(n1 == 1){
                    adj.get(i).add(j);
                }
            }
            
        }
        int ans = 0;
        for(int i = 0;i<vis.length;i++){
            if(!vis[i]){
                ans++;
                dfs(adj,vis,i);
            }
        }
        return ans;
    }
    public static void dfs(ArrayList<ArrayList<Integer>> graph, boolean[] vis, int start){
        if(!vis[start]){
            vis[start] = true;
            int size = graph.get(start).size();
            for(int i = 0;i<size;i++){
                dfs(graph,vis,graph.get(start).get(i));
            }
        }
    }
}