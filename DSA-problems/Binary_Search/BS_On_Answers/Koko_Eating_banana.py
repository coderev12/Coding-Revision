# https://leetcode.com/problems/koko-eating-bananas/description/
def minEatingSpeed(self, piles: List[int], h: int) -> int:
    me = max(piles)

    l = 1
    r = me

    while l <= r:
        # calculcu
        m = l + (r - l) // 2
        if self.checkForGood(piles, m) <= h:
            r = m - 1
        else:
            l = m + 1
    return l


def checkForGood(self, piles: List[int], mid: int):
    hours = 0
    for pile in piles:
        hours += ceil(pile / mid)
    return hours
