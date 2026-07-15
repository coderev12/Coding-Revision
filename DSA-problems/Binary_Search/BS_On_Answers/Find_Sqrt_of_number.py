# https://www.geeksforgeeks.org/problems/square-root/1
def floorSqrt(self, n):
    l = 0
    r = n

    while (l <= r):
        m = l + (r - l) // 2
        num = m * m
        if num == n:
            return m
        elif num >= n:
            r = m - 1
        else:
            l = m + 1

    return r
