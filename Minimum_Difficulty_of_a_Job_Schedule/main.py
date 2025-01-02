class Solution:

    def solve(self, nums: List[int], index: int, d: int, dp: List[List[int]]):
        if index >= len(nums):
            return (10 ** 9)
        if d == 1:
            temp = 0
            for i in range(index, len(nums)):
                temp = max(temp, nums[i])
            return temp
        if dp[index][d] != -1:
            return dp[index][d]
        res, curr = inf, 0
        for i in range(index, len(nums)):
            curr = max(curr, nums[i])
            res = min(res, curr + self.solve(nums, i + 1, d - 1, dp))
        dp[index][d] = res
        return dp[index][d]

    def minDifficulty(self, jobDifficulty: List[int], d: int) -> int:
        if len(jobDifficulty) < d:
            return -1
        dp = [[-1] * (d + 1)] * len(jobDifficulty)
        ans = self.solve(jobDifficulty, 0, d, dp)
        return ans
