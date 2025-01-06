class Solution:
    def mergeStones(self, stones: List[int], k: int) -> int:
        if (len(stones) - 1) % (k - 1):
            return -1
        prefix = [0] * (len(stones) + 1)
        for i in range(len(stones)):
            prefix[i + 1] = prefix[i] + stones[i]
        def dp(i, j):
            if j - i + 1 < k:
                return 0
            res = min(dp(i, mid) + dp(mid + 1, j) for mid in range(i, j, k - 1))
            if not (j - i) % (k - 1):
                res += prefix[j + 1] - prefix[i]
            return res
        return dp(0, len(stones) - 1)
