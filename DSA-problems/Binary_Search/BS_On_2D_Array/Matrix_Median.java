// https://www.geeksforgeeks.org/problems/median-in-a-row-wise-sorted-matrix1527/1
class Solution {
    public int median(int[][] mat) {
       int n = mat.length;
       int m = mat[0].length;
       
       int low = Integer.MAX_VALUE;
       int high = Integer.MIN_VALUE;
       
       for(int i = 0;i<n;i++){
           low = Math.min(low,mat[i][0]);
       }
       
       int target = (n * m) / 2;
       for(int i = 0;i<n;i++){
           high = Math.max(high,mat[i][m - 1]);
       }
       
       while(low <= high){
           int mid = low + (high - low) / 2;
           
           if(getSmaller(mat,mid) > target){
               high = mid - 1;
           }else{
               low = mid + 1;
           }
       }
       return low;
    }
    
    public static int getSmaller(int[][] mat, int tar){
        int n = mat.length;
        int ans = 0;
        for(int i = 0;i<n;i++){
            ans += upperBound(mat[i],tar);
        }
        return ans;
    }
    
    public static int upperBound(int[] arr, int target){
        int low = 0;
        int high = arr.length - 1;
        
        while(low <= high){
            int mid = low + (high - low) / 2;
            
            if(arr[mid] <= target){
                low = mid + 1;
            }else{
                high = mid - 1;
            }
        } 
        
        return low;
    }
}