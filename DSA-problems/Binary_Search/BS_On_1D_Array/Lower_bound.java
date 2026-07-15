#https://www.geeksforgeeks.org/problems/implement-lower-bound/1
int lowerBound(int[] arr, int target) {
        int n = arr.length;
        int left = 0;
        int right = n - 1;
        while(left <= right){
            int mid = (left + (right - left)/2);
            if(arr[mid] == target){
                right = mid - 1;
            }else if(arr[mid] > target){
                right = mid - 1;
            }else{
                left = mid + 1;
            }
            //System.out.println(left + " " + right);
        }
        
        return left == n - 1 && arr[left] < target ? n : left;
    }