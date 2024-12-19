class Solution:
    res = 0
    def traverse(self, s: str, l: int, r: int):
        while l >= 0 and r < len(s) and s[l] == s[r]:
            self.res += 1
            l -= 1
            r += 1
    def countSubstrings(self, s: str) -> int:
        for i in range(len(s)):
            self.traverse(s, i, i)
            self.traverse(s, i, i + 1)
        return self.res
