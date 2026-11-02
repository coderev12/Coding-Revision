PS: https://leetcode.com/problems/number-of-islands/description/
class Solution {
    public int numIslands(char[][] grid) {
        int noOfIsland = 0;
        for(int i =0;i<grid.length;i++){
            for(int j = 0;j<grid[0].length;j++){
                if(grid[i][j] == '1'){
                    // System.out.println("Hi");
                    noOfIsland++;
                    dfs(grid,i,j);
                }
            }
        }
        return noOfIsland;
    }
    public static void dfs(char[][] grid,int sr, int sc){
        if(sr >= 0 && sr < grid.length && sc >= 0 && sc < grid[0].length && grid[sr][sc] == '1'){
            grid[sr][sc] = '0';
            dfs(grid,sr+1,sc);
            dfs(grid,sr,sc+1);
            dfs(grid,sr-1,sc);
            dfs(grid,sr,sc-1);
        }
    }
}