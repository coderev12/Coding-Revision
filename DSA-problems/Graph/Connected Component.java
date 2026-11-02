PS: https://takeuforward.org/practice/dsa/connected-components
class Solution {
    public int findNumberOfComponent(int V, List<List<Integer>> edges) {
        boolean[] vis = new boolean[V];
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0;i<V;i++){
            adj.add(new ArrayList<>());
        }
        for(int i = 0;i<edges.size();i++){
            int n1 = edges.get(i).get(0);
            int n2 = edges.get(i).get(1);
            adj.get(n1).add(n2);
            adj.get(n2).add(n1);
        }
        int ans = 0;
        for(int i = 0;i<vis.length;i++){
            if(!vis[i]){
                ans++;
                dfs(graph,vis,i);
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
