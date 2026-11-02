PS: https://leetcode.com/problems/course-schedule/description/
class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        boolean[] pathVis = new boolean[numCourses];
        boolean[] vis = new boolean[numCourses];
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0;i<numCourses;i++){
            adj.add(new ArrayList<>());
        }
        for(int i = 0;i<prerequisites.length;i++){
            int x = prerequisites[i][0];
            int y = prerequisites[i][1];
            adj.get(x).add(y);
        }
        for(int i = 0;i<numCourses;i++){
            if(!vis[i]){
                if (isCyclic(adj,i,pathVis,vis)) return false;
            } 
        }
        return true;
    }
    public static boolean isCyclic(List<List<Integer>> adj, int node, boolean[] pathVis, boolean[] vis){
        vis[node] = true;
        pathVis[node] = true;
        for(int a : adj.get(node)){
            if(!vis[a]){
                if(isCyclic(adj,a,pathVis,vis)) return true;
            }
            else if (pathVis[a]) return true;
        }
        pathVis[node] = false;
        return false;
    }
}