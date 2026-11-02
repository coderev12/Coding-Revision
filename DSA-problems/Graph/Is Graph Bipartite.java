PS: https://leetcode.com/problems/is-graph-bipartite/description/
class Solution {
    public boolean isBipartite(int[][] graph) {
        List<List<Integer>> adj = new ArrayList<>();
        int colors[] = new int[graph.length];
        for(int i = 0;i<graph.length;i++){
            if(colors[i] == 0){
                if(!isBipartite(graph,i,colors,1)) return false;
            }
        }

        return true;
    }
    public static boolean isBipartite(int[][] graph, int start, int[] color, int currColor){
        if(color[start] != 0){
            return color[start] == currColor;
        }
        color[start] = currColor;
        int nextColor = (currColor == 1) ? 2 : 1;
        for(Integer a: graph[start]){
            if(!isBipartite(graph,a,color,nextColor)) return false;
        }
        return true;
    }
}