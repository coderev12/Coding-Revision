PS: https://leetcode.com/problems/number-of-enclaves/description/
class Solution {
    public int numEnclaves(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        boolean[][] vis = new boolean[n][m]; 
        for(int i = 0;i<grid.length;i++){
            if(grid[i][0] == 1) dfs(grid,i,0,vis);
            if(grid[i][m-1] == 1) dfs(grid,i,m-1,vis);
        }
        for(int i = 0;i<grid[0].length;i++){
            if(grid[0][i] == 1) dfs(grid,0,i,vis);
            if(grid[n - 1][i] == 1) dfs(grid,n-1,i,vis);
        }
        int ans = 0;
        for(int i = 0;i<n;i++){
            for(int j = 0;j<m;j++){
                if(grid[i][j] == 1) ans++;
            }
        }
        return ans;
    }
    public static void dfs(int[][] grid, int start, int end, boolean[][] vis){
        if(start < 0 || start >= grid.length || end < 0 || end >= grid[0].length || grid[start][end] == 0) return;
        if(!vis[start][end]){
            vis[start][end] = true;
            grid[start][end] = 0;
            dfs(grid,start+1, end,vis);
            dfs(grid,start, end+1,vis);
            dfs(grid,start - 1, end,vis);
            dfs(grid,start, end - 1,vis);
        }
    }
}