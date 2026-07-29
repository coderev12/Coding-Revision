// https://leetcode.com/problems/search-a-2d-matrix/
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        // imagine the 2D array to be an 1D array:
        int n = matrix.length;
        int m = matrix[0].length;
        System.out.println(n + " " + m);
        int low = 0;
        int high = (n * m) - 1;
        while(low <= high){
            int mid = (low) + (high - low) / 2;

            // convert it into 2 d corrdinates

            int x = mid / m;
            int y = mid % m;

            if(matrix[x][y] == target){
                return true;
            }else if(matrix[x][y] > target){
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }
        return false;
    }
}
