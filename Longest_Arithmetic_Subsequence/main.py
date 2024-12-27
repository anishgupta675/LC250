class Solution:
    def longestArithSeqLength(self, nums: List[int]) -> int:
        if len(nums) <= 2:
            return len(nums)
        longest = 2
        longest, dp = 2, [{}] * len(nums)
        for i in range(len(nums)):
            for j in range(i):
                dp[i][nums[i] - nums[j]] = dp[j][nums[i] - nums[j]] + 1 if nums[i] - nums[j] in dp[j] else 2
                longest = max(longest, dp[i][nums[i] - nums[j]])
        return longest
