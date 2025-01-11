class Solution:
    def countPalindromicSubsequences(self, s: str) -> int:
        dp, next_occ, prev_occ, hmap = [[0] * len(s)] * len(s), [0] * len(s), [0] * len(s), {}
        for i in range(len(s)):
            if s[i] not in hmap:
                prev_occ[i] = -1
            else:
                prev_occ[i] = hmap[s[i]]
            hmap[s[i]] = i
        hmap.clear()
        for i in range(len(s) - 1, -1, -1):
            if s[i] not in hmap:
                next_occ[i] = -1
            else:
                next_occ[i] = hmap[s[i]]
            hmap[s[i]] = i
        for i in range(len(s)):
            j, k = 0, i
            while k < len(s):
                if not i:
                    dp[j][k] = 1
                elif i == 1:
                    dp[j][k] = 2
                else:
                    if s[j] != s[k]:
                        dp[j][k] = dp[j + 1][k] + dp[j][k - 1] - dp[j + 1][k - 1]
                    else:
                        if next_occ[j] > prev_occ[k]:
                            dp[j][k] = 2 * dp[j + 1][k - 1] + 2
                        elif next_occ[j] == prev_occ[k]:
                            dp[j][k] = 2 * dp[j + 1][k - 1] + 1
                        else:
                            dp[j][k] = 2 * dp[j + 1][k - 1] - dp[next_occ[j] + 1][prev_occ[k] - 1]
                j += 1
                k += 1
        return dp[0][len(s) - 1]
