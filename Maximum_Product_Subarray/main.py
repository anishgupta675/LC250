class Solution:
    def maxProduct(self, nums: List[int]) -> int:
        result, p1, p2 = nums[0], nums[0], nums[0]
        for i in range(1, len(nums)):
            temp = max(nums[i], p1 * nums[i], p2 * nums[i])
            p2 = min(nums[i], p1 * nums[i], p2 * nums[i])
            p1 = temp
            result = max(p1, result)
        return result
