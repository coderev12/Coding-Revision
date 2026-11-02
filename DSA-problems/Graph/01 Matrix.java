PS: https://leetcode.com/problems/01-matrix/description/
class Solution {

    class Pair {
        int row, col, dis;

        Pair(int row, int col, int dis) {
            this.row = row;
            this.col = col;
            this.dis = dis;
        }
    }

    public int[][] updateMatrix(int[][] mat) {

        int n = mat.length;
        int m = mat[0].length;

        int[][] ans = new int[n][m];
        boolean[][] vis = new boolean[n][m];

        Queue<Pair> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                if (mat[i][j] == 0) {
                    q.offer(new Pair(i, j, 0));
                    vis[i][j] = true;
                }
            }
        }

        int[][] dir = {
            {-1, 0},
            {1, 0},
            {0, -1},
            {0, 1}
        };
        while (!q.isEmpty()) {

            Pair node = q.poll();

            int row = node.row;
            int col = node.col;
            int dis = node.dis;

            ans[row][col] = dis;

            for (int i = 0; i < 4; i++) {

                int newRow = row + dir[i][0];
                int newCol = col + dir[i][1];

                if (newRow < 0 || newRow >= n ||
                    newCol < 0 || newCol >= m ||
                    vis[newRow][newCol]) {
                    continue;
                }

                vis[newRow][newCol] = true;

                q.offer(
                    new Pair(newRow, newCol, dis + 1)
                );
            }
        }

        return ans;
    }
}