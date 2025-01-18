class Solution:
    def getLPS(self, needle: str) -> List[int]:
        size, lps = 0, [0] * len(needle)
        for i in range(1, len(needle)):
            if needle[i] == needle[size]:
                size += 1
                lps[i] = size
                i += 1
            else:
                if size:
                    size = lps[size - 1]
                else:
                    lps[i] = 0
                    i += 1
        return lps

    def strStr(self, haystack: str, needle: str) -> int:
        if not needle or not haystack or len(needle) > len(haystack):
            return -1
        i, j, lps = 0, 0, self.getLPS(needle)
        while i < len(haystack):
            if needle[j] == haystack[i]:
                i += 1
                j += 1
            if j == len(needle):
                return i - j
                j = lps[j - 1]
            elif i < len(haystack) and needle[j] != needle[i]:
                if j:
                    j = lps[j - 1]
                else:
                    i += 1
        return -1
