PS: https://leetcode.com/problems/flood-fill/description/
class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int n = image.length;
        int m = image[0].length;
        boolean[][] vis = new boolean[n][m];
        floodFill(image,sr,sc,color,image[sr][sc],vis);
        return image;
    }
    public static void floodFill(int[][] image, int sr, int sc, int color, int currColor,boolean[][] vis){
        if(sr < 0 || sr >= image.length || sc < 0 || sc >= image[0].length || image[sr][sc] != currColor || vis[sr][sc] ){
            return;
        }
        image[sr][sc] = color;
        vis[sr][sc] = true;
        floodFill(image,sr+1,sc,color,currColor,vis);
        floodFill(image,sr,sc + 1,color,currColor,vis);
        floodFill(image,sr-1,sc,color,currColor,vis);
        floodFill(image,sr,sc - 1,color,currColor,vis);
        
    }
}