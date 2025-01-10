class Solution {
public:
    int superEggDrop(int k, int n) {
        if(!n || n == 1) return n;
        if(k == 1) return n;
        vector<vector<int>> dp(k + 1, vector<int>(n + 1, 0));
        for(int i = 0; i <= k; i++) {
            dp[i][0] = 0;
            dp[i][1] = 1;
        }
        for(int i = 0; i <= n; i++) {
            dp[0][i] = 0;
            dp[1][i] = 1;
        }
        for(int i = 2; i <= k; i++) {
            for(int j = 2; j <= n; j++) {
                int l = 1, r = j, temp = 0, ans = INT_MAX;
                while(l <= r) {
                    int mid = (l + r) >> 1;
                    int low = dp[i - 1][mid - 1], high = dp[i][j - mid];
                    temp = 1 + max(low, high);
                    if(low < high) l = mid + 1;
                    else r = mid - 1;
                    ans = min(ans, temp);
                }
                dp[i][j] = ans;
            }
        }
        return dp[k][n];
    }
};
