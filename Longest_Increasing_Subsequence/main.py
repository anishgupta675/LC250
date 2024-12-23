class Solution:
    def lower_bound(self, nums: List[int], low: int, high: int, target: int):
        if low > high:
            return low
        mid = (low + high) >> 1
        if target <= nums[mid]:
            return self.lower_bound(nums, low, mid - 1, target)
        return self.lower_bound(nums, mid + 1, high, target)
    def lengthOfLIS(self, nums: List[int]) -> int:
        count, res = 1, []
        res.append(nums[0])
        for i in range(1, len(nums)):
            if nums[i] > res[-1]:
                res.append(nums[i])
                count += 1
            else:
                res[self.lower_bound(res, 0, len(res) - 1, nums[i])] = nums[i]
        return len(res)
