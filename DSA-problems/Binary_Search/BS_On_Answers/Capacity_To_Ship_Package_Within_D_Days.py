# https://leetcode.com/problems/capacity-to-ship-packages-within-d-days/description/
def shipWithinDays(self, weights: List[int], days: int) -> int:
    l = max(weights)
    r = sum(weights)

    while l <= r:
        m = l + (r - l) // 2
        if self.check(weights, days, m):
            r = m - 1
        else:
            l = m + 1

        print(str(l) + " " + str(r))
    return l


def check(self, we: List[int], days, cn):
    ans = 0
    itr = cn
    for i in range(len(we)):
        itr -= we[i]
        if (itr < 0):
            itr = cn - we[i]
            ans += 1
    print(str(ans))
    return True if ans < days else False
