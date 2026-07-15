# https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/description/
def findMin(self, nums: List[int]) -> int:
    l = 0
    r = len(nums) - 1
    ans = 5001
    while l <= r:
        m = l + (r - l) // 2
        if nums[l] <= nums[m]:
            ans = min(ans, nums[l])
            l = m + 1
        else:
            ans = min(ans, nums[m])
            r = m - 1

    return ans
