class Solution:
    def validPalindrome(self, s: str) -> bool:
        mid = (len(s) >> 1) + 1
        rev = s[-mid:][::-1]
        if s[:mid] == rev:
            return True
        for i in range(mid):
            if s[i] != rev[i]:
                return s[i + 1:mid] == rev[i:mid - 1] or s[i:mid - 1][i + 1:]
        return True
