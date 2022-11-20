import java.util.*;
class Solution {
    int[] dp = new int[100];
    public int climbStairs(int n) {
        if(n == 1) return dp[n] = 1;
        if(n == 2) return dp[n] = 2;
        if(dp[n] != 0) return dp[n];
        return dp[n] = climbStairs(n - 1) + climbStairs(n - 2);
    }
    public static void main(String[] args) throws Exception {}
}