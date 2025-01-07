class Solution {
    int lps(string s) {
        if(s.length() == 1) return 1;
        if(s.length() == 2) return (s[0] == s[1]) + 1;
        vector<vector<int>> dp(s.length(), vector<int>(s.length(), 0));
        for(int i = 1; i <= s.length(); i++) {
            for(int j = 0; j <= s.length() - i; j++) {
                int k = i + j - 1;
                if(i == 1) {
                    dp[j][k] = 1;
                    continue;
                }
                if(s[j] == s[k]) dp[j][k] = dp[j + 1][k - 1] + 2;
                else dp[j][k] = max(dp[j + 1][k], dp[j][k - 1]);
            }
        }
        return dp[0][s.length() - 1];
    }
public:
    int minInsertions(string s) { return s.length() - lps(s); }
};
