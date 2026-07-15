# https://leetcode.com/problems/single-element-in-a-sorted-array/description/
def singleNonDuplicate(self, nums: List[int]) -> int:
    l = 0
    r = len(nums) - 1

    while l <= r:
        mid = l + (r - l) // 2
        if len(nums) == 1:
            return nums[0]
        left_side = True if mid != 0 and nums[mid] == nums[mid - 1] else False
        right_side = True if mid != len(
            nums) - 1 and nums[mid] == nums[mid + 1] else False

        if not (left_side or right_side):
            return nums[mid]

        if (mid % 2 == 0 and nums[mid + 1] == nums[mid]) or (mid % 2 != 0 and nums[mid] == nums[mid - 1]):
            l = mid + 1
        else:
            r = mid - 1

    return -1
