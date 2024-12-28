class Solution:
    def trap(self, height: List[int]) -> int:
        ans, dp1, dp2 = 0, [0] * len(height), [0] * len(height)
        dp1[0] = height[0]
        for i in range(len(dp1)):
            dp1[i] = max(dp1[i - 1], height[i])
        dp2[-1] = height[-1]
        for i in range(len(dp2) - 2, -1, -1):
            dp2[i] = max(dp2[i + 1], height[i])
        for i in range(len(height)):
            ans+= min(dp1[i], dp2[i]) - height[i]
        return ans
