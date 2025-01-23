class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        i, res, last_index = 0, 0, {}
        for j in range(len(s)):
            last_index[s[j]] = -1
        for j in range(len(s)):
            i = max(i, last_index[s[j]] + 1)
            res = max(res, j - i + 1)
            last_index[s[j]] = j
        return res
