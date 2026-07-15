# https://leetcode.com/problems/search-in-rotated-sorted-array/description/
def search(self, nums: List[int], target: int) -> int:
    l = 0
    r = len(nums) - 1
    n = len(nums)
    while l <= r:
        m = l + (r - l) // 2
        if nums[m] == target:
            return m
        else:
            if nums[l] <= nums[m]:
                if nums[l] <= target < nums[m]:
                    r = m - 1
                else:
                    l = m + 1
            else:
                if nums[m] < target <= nums[r]:
                    l = m + 1
                else:
                    r = m - 1

    return -1
