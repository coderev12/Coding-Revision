# https://www.geeksforgeeks.org/problems/aggressive-cows/1
class Solution:
    def aggressiveCows(self, arr, k):
        arr.sort()
        n = len(arr)
        l = 1
        h = arr[n - 1] - arr[0]

        while l <= h:
            m = l + (h - l) // 2

            if self.check(arr, k, m):
                l = m + 1
            else:
                h = m - 1

        return h

    def check(self, arr, k, dis):
        last = arr[0]
        countCoy = 1

        for i in range(1, len(arr)):
            if arr[i] - last >= dis:
                countCoy += 1
                last = arr[i]

            if countCoy >= k:
                return True

        return False
