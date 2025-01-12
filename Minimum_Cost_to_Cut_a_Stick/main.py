class Solution:
    dp = []

    def minCost(self, n: int, cuts: List[int]) -> int:
        for i in range(len(cuts)):
            self.dp.append([-1] * len(cuts))
        return self.minCostUtil(0, n, cuts, 0, len(cuts) - 1)

    def minCostUtil(self, start: int, end: int, cuts: List[int], l: int, r: int) -> int:
        if not self.dp or l > r or l >= len(self.dp) or r >= len(self.dp[0]):
            return 0
        if self.dp[l][r] != -1:
            return self.dp[l][r]
        cost = float("inf")
        for i in range(l, r + 1):
            lcost, rcost = self.minCostUtil(start, cuts[i], cuts, l, i - 1), self.minCostUtil(cuts[i], end, cuts, i + 1, r)
            cost = min(cost, (end - start) + lcost + rcost)
        return self.dp[l][r]
