class Solution:
    res_low = 0
    res_high = 0
    res_len = 0
    def _longestPalindrome(self, s: str, low: int, high: int):
        if low < 0 or high >= len(s) or s[low] != s[high]:
            return
        if high - low + 1 > self.res_len:
            self.res_low = low
            self.res_high = high
            self.res_len = high - low + 1
        return self._longestPalindrome(s, low - 1, high + 1)
    def longestPalindrome(self, s: str) -> str:
        self.res_low = 0
        self.res_high = 0
        self.res_len = 0
        for i in range(len(s)):
            self._longestPalindrome(s, i, i)
            self._longestPalindrome(s, i, i + 1)
        return s[self.res_low:self.res_high + 1]
