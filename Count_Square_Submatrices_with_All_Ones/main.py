class Solution:
    def countSquares(self, matrix: List[List[int]]) -> int:
        res, dp = 0, [[0] * len(matrix[0])] * len(matrix)
        for i in range(len(matrix)):
            for j in range(len(matrix[i])):
                if not matrix[i][j]:
                    dp[i][j] = 0
                elif not i or not j:
                    dp[i][j] = 1
                    res += 1
                else:
                    dp[i][j] = min(dp[i - 1][j], dp[i - 1][j - 1], dp[i][j - 1]) + 1
                    res += dp[i][j]
        return res
