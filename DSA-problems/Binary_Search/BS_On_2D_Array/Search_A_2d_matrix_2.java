// https://leetcode.com/problems/search-a-2d-matrix-ii/
class Solution {
    // Main solution traversal based Complexity O(n + m)

    public boolean searchMatrix(int[][] matrix, int target) {
        int i = 0;
        int j = matrix[0].length - 1;
        int n = matrix.length;
        int m = matrix[0].length;
        while(i < n && i >= 0 && j < m && j >= 0){
           
            if(matrix[i][j] == target) return true;
            else if(matrix[i][j] > target) j--;
            else i++;
        }
        return false;
        
    }   


    // 1st solution is binary search Complexicty (O(nLogm))
    // public boolean searchMatrix(int[][] matrix, int target) {
    //     int n = matrix.length;
    //     int m = matrix[0].length;
    //     for(int i = 0;i<n;i++){
    //         int fi = matrix[i][0];
    //         int ls = matrix[i][m - 1];

    //         if(fi <= target && ls >= target){
    //             if(bs(matrix[i],target)) return true;
    //         }
    //     }
    //     return false;
    // }   
    // public static boolean bs(int[] arr, int target){
    //     int low = 0;
    //     int high = arr.length - 1;

    //     while(low <= high){
    //         int mid = low + (high - low) / 2;
    //         if(arr[mid] == target) return true;
    //         if(arr[mid] > target) high = mid - 1;
    //         else low = mid + 1;
    //     }
    //     return false;
    // }
}