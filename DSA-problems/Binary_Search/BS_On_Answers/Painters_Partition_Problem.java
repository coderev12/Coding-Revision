// https://www.geeksforgeeks.org/problems/the-painters-partition-problem1535/1
class Solution {
    public int minTime(int[] arr, int k) {
        // code here
        int low = Integer.MIN_VALUE;
        int high = 0;
        
        int n = arr.length;
        for(int i = 0;i<n;i++){
            low = Math.max(arr[i],low);
            high += arr[i];
        }
        while(low <= high){
            int mid = low + ((high - low)/2);
            int timeRequired = getTime(arr,mid);
            
            if(timeRequired > k){
                low = mid + 1;
            }else{
                high = mid - 1;
            }
            
        }
        return low;
        
    }
    
    public static int getTime(int[] arr, int mid){
        int time = 1;
        int prevTime = 0;
        int n = arr.length;
        for(int i = 0;i<n;i++){
            if(arr[i] + prevTime <= mid){
                prevTime += arr[i];
            }else{
                time++;
                prevTime = arr[i];
            }
        }
        return time;
    }
}
