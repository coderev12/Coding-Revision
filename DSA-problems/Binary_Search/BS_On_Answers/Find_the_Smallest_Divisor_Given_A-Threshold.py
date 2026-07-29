# https://leetcode.com/problems/find-the-smallest-divisor-given-a-threshold/description/
def smallestDivisor(self, nums: List[int], threshold: int) -> int:
    l = 1
    r = max(nums)

    while (l <= r):
        m = l + (r - l) // 2
        if self.check(nums, threshold, m):
            r = m - 1
        else:
            l = m + 1

    return l


def check(self, nums: List[int], t, m):
    ans = 0
    for i in range(len(nums)):
        ans += ceil(nums[i]/m)

    return True if ans <= t else False
