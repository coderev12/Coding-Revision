// https://www.geeksforgeeks.org/problems/allocate-minimum-number-of-pages0937/1
class Solution {
    public int findPages(int[] arr, int k) {
        // code here
        int n = arr.length;
        int min = arr[0];
        long sum = arr[0];
        if(k > n) return -1;
        for(int i = 1;i<n;i++){
            if(arr[i] > min){
                min = arr[i];
            }
            sum += (long) arr[i];
        }
        
        while (min <= sum){
            int m = min + (sum - min) / 2;
            int number = check(arr,k,m);
            if(number > k){
                min = m + 1;
            }else{
                sum = m - 1;
            }
        }
        
        return min;
        
        
    }
    
    public static int check(int[] arr, int k, int m){
        long pageCount = 0L;
        int ans = 1;
        for(int i = 0;i<arr.length;i++){
            if((long) arr[i] +  pageCount <= m){
                pageCount += (long) arr[i];
                
            }else{
                ans++;
                pageCount = (long)arr[i];
            }
        }
        return ans;
    }
}