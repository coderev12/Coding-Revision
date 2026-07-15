# https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/description/
def searchRange(self, nums: List[int], target: int) -> List[int]:
    left = 0
    right = len(nums) - 1

    while left <= right:
        mid = l + (r - l) // 2
        if nums[mid] == target:
            if (mid + 1 < len(nums)):
                if nums[mid + 1] == nums[mid]:
                    left = mid + 1
                else:
                    right = mid
        elif nums[mid] > target:
            right = mid - 1
        else:
            left = mid + 1

    return [left, right]
