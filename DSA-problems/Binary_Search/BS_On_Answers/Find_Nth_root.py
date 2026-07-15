# https://www.geeksforgeeks.org/problems/find-nth-root-of-m5843/1
def nthRoot(self, n, m):
    l = 1
    r = m

    if m == 0:
        return 0

    while l <= r:
        mid = l + (r - l)//2
        num = pow(mid, n)
        if num == m:
            return mid
        elif num >= m:
            r = mid - 1
        else:
            l = mid + 1

    return -1
