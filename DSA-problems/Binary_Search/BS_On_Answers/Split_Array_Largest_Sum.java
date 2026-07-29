// https://leetcode.com/problems/split-array-largest-sum/
class Solution {
    public int splitArray(int[] nums, int k) {
        int low = Integer.MIN_VALUE;
        int high = 0;
        int n = nums.length;
        for(int i = 0;i<n;i++){
            high += nums[i];
            low = Math.max(low,nums[i]);
        }

        while (low <= high){
            int mid = low + ((high - low) / 2);
            int checkIfItSplitted = check(nums,mid);
            if(checkIfItSplitted > k){
                low = mid + 1;
            }else{
                high = mid - 1;
            }
        }
        return low;

    }

    public static int check(int[] nums, int mid){
        int sum = 0;
        int split = 1;
        int n = nums.length;
        for(int i = 0;i<n;i++){
            if(sum + nums[i] <= mid){
                sum += nums[i];
            }else{
                sum = nums[i];
                split++;
            }
        }
        return split;
    }
}