class Solution:
    def uniquePaths(self, m: int, n: int) -> int:
        def dfs(dp: list[list[int]], m: int, n: int) -> int:
            if m < 0 or n < 0:
                return 0
            if not m and not n:
                return 1
            if dp[m][n]:
                return dp[m][n]
            dp[m][n] = dfs(dp, m - 1, n) + dfs(dp, m, n - 1)
            return dp[m][n]
        dp = [[0 for j in range(n)] for i in range(m)]
        return dfs(dp, m - 1, n - 1)
