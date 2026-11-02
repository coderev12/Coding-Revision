PS: https://leetcode.com/problems/surrounded-regions/description/
class Solution {
    public void solve(char[][] board) {
        int n = board.length;
        int m = board[0].length;
        boolean[][] vis = new boolean[n][m];
        for(int i = 0;i < n;i++){
            if(!vis[i][0] &&  board[i][0] == 'O') dfs(board,i,0,vis);
            if(!vis[i][m-1] && board[i][m - 1] == 'O') dfs(board,i,m-1,vis);
        }
        for(int i = 0;i < m;i++){
            if(!vis[0][i] && board[0][i] == 'O') dfs(board,0,i,vis);
            if(!vis[n-1][i] && board[n - 1][i] == 'O') dfs(board,n-1,i,vis);
        } 
       
        for(int i = 0;i<n;i++){
            for(int j = 0;j<m;j++){
                if(!vis[i][j] &&  board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }
    }
    public static void dfs(char[][] board, int i, int j, boolean[][] vis){
        if(i < 0 || i >= board.length || j < 0 || j >= board[0].length || vis[i][j] || board[i][j] == 'X') return;

        vis[i][j] = true;
        dfs(board,i+1,j,vis);
        dfs(board,i-1,j,vis);
        dfs(board,i,j+1,vis);
        dfs(board,i,j-1,vis);
    }
}