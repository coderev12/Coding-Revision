PS: https://leetcode.com/problems/rotting-oranges/description/
class Solution {
    class Pair{
        int row,col,time;
        Pair(int row, int col, int time){
            this.row = row;
            this.col = col;
            this.time = time;
        }
    }
    public int orangesRotting(int[][] grid) {
        Queue<Pair> q = new LinkedList<Pair>();
        boolean[][] vis = new boolean[grid.length][grid[0].length];
        int rot = 0;
        int fresh = 0;
        for(int i = 0;i<grid.length;i++){
            for(int j = 0;j< grid[i].length;j++){
                if(grid[i][j] == 2){
                    q.add(new Pair(i,j,0));
                    vis[i][j] = true;
                }
                if(grid[i][j] == 1){
                    fresh++;
                }
            }
        }    
        int max = 0;
        int[][] dir = {{-1,0},{1,0},{0,-1},{0,1}};
        int n = dir.length;
        while(!q.isEmpty()){
            Pair p = q.poll();
            max = Math.max(max,p.time);
            for(int i = 0;i<n;i++){
                int x = p.row + dir[i][0];
                int y = p.col + dir[i][1];
                if(x < 0 || y < 0 || x >= grid.length || y >= grid[0].length || vis[x][y] || grid[x][y] == 0){
                    continue;
                }
                q.add(new Pair(x,y,p.time+1));
                rot++;
                vis[x][y] = true;
            }
        }
        System.out.println(rot);
        return rot == fresh ? max : -1;
    }
}