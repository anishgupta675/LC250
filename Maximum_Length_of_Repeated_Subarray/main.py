class Solution:
    def findLength(self, nums1: List[int], nums2: List[int]) -> int:
        dp = [0] * (len(nums2) + 1)
        max_len = 0
        for i in range(1, len(nums1) + 1):
            for j in range(len(nums2), 0, -1):
                if nums1[i - 1] == nums2[j - 1]:
                    dp[j] = 1 + dp[j - 1]
                    max_len = max(max_len, dp[j])
                else:
                    dp[j] = 0
        return max_len
