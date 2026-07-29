https://leetcode.com/problems/find-a-peak-element-ii/description/
class Solution {
    public int[] findPeakGrid(int[][] mat) {
        int low = 0;
        int high = mat.length - 1;
        int n = mat.length;
        int m = mat[0].length;
        while(low <= high){
            int mid = low + (high - low) / 2;
            int[] midarr = mat[mid];
            int max = -1;
            int index = -1;
            for(int i = 0;i<midarr.length;i++){
                if(max < midarr[i]){
                    max = midarr[i];
                    index = i;
                }
            }
            // check for the elements top, bottom becauyase left and right are already corret becauyse it is the maximum element
            int current = mat[mid][index];
            int top = mid - 1 < 0 ? -1 : mat[mid - 1][index];
            int bottom = mid + 1 >= n ? - 1 : mat[mid + 1][index];
        
            if(current > top && current > bottom){
                return new int [] {mid,index};
            }else if(current < top){
                high  = mid - 1;
            }else{
                low = mid + 1;
            }
            
            
        }
        
        return new int [] {};
    }
}