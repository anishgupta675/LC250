class Solution:
    def countDigitOne(self, n: int) -> int:
        count, i = 0, 1
        while i <= n:
            count += (n / (i * 10)) * i + min(max(n % (i * 10) - i + 1, 0), i)
            i *= 10
        return count
