class Solution:
    def maxProfit(self, k: int, prices: List[int]) -> int:
        dp = [-inf] * (2 * k + 1)
        dp[0] = 0
        for i in range(len(prices)):
            for j in range(0, 2 * k - 1, 2):
                dp[j + 1] = max(dp[j + 1], dp[j] - prices[i])
                dp[j + 2] = max(dp[j + 2], dp[j + 1] + prices[i])
        return max(dp)
