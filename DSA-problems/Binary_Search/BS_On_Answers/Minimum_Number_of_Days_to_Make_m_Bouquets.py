# https://leetcode.com/problems/minimum-number-of-days-to-make-m-bouquets/description/
def minDays(self, bloomDay: List[int], m: int, k: int) -> int:
    if ((m * k) > len(bloomDay)):
        return -1
    l = min(bloomDay)
    r = max(bloomDay)
    while l <= r:
        mid = l + (r - l) // 2
        if self.checkIfPos(bloomDay, m, k, mid):
            r = mid - 1
        else:
            l = mid + 1

    return l


def checkIfPos(self, bloomDay: List[int], m: int, k: int, days: int):
    cnt = 0
    ans = 0
    for i in range(len(bloomDay)):
        if bloomDay[i] <= days:
            cnt += 1
        else:
            ans += (cnt) // k
            cnt = 0
    ans += (cnt) // k
    return True if ans >= m else False
