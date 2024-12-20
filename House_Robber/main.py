class Solution:
    def rob(self, nums: List[int]) -> int:
        if len(nums) == 1:
            return nums[0]
        if len(nums) == 2:
            return max(nums[0], nums[1])
        rob0, rob1 = nums[0], max(nums[0], nums[1])
        for i in range(2, len(nums)):
            rob2 = max(nums[i] + rob0, rob1)
            rob0 = rob1
            rob1 = rob2
        return rob1
