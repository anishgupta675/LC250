class Solution:
    def longestCommonPrefix(self, strs: List[str]) -> str:
        if not len(strs):
            return " "
        if len(strs) == 1:
            return strs[0]
        strs.sort()
        i = 0
        while i < min(len(strs[0]), len(strs[-1])) and strs[0][i] == strs[-1][i]:
            i += 1
        return strs[0][:i]
