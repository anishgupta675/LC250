class Solution:
    def knightDialer(self, n: int) -> int:
        if n == 1:
            return 10
        mod, jumps, dp, res = 10**9 + 7, [[4, 6], [6, 8], [7, 9], [4, 8], [3, 9, 0], [], [1, 7, 0], [2, 6], [1, 3], [2, 4]], [1] * 10, 0
        for j in range(n - 1):
            next_dp = [0] * 10
            for n in range(10):
                for k in jumps[n]:
                    next_dp[k] = (next_dp[k] + dp[n]) % mod
            dp = next_dp
        for n in dp:
            res = (res + n) % mod
        return res
