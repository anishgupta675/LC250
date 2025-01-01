class Solution:
    def minDistance(self, word1: str, word2: str) -> int:
        f, s = [0] * (len(word1) + 1), [0] * (len(word2) + 1)
        for i in range(len(word2) + 1):
            f[i] = i
        for i in range(len(word1) + 1):
            s[0] = i
            for j in range(1, len(word2) + 1):
                if word1[i - 1] == word2[j - 1]:
                    s[j] = f[j - 1]
                else:
                    s[j] = 1 + min(f[j - 1], f[j], s[j - 1])
            f = s
        return f[len(word2)]
