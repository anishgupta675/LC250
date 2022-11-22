import java.util.*;
class Solution {
    private int ways(int i, String s, int[] dp) {
        if(i == s.length()) return 1;
        if(s.charAt(i) == '0') return 0;
        if(dp[i] != -1) return dp[i];
        int x = ways(i + 1, s, dp), y = 0;
        if(i < s.length() - 1 && (s.charAt(i) == '1' || s.charAt(i) == '2' && s.charAt(i + 1) <= '6')) y+= ways(i + 2, s, dp);
        return dp[i] = x + y;
    }
    public int numDecodings(String s) {
        int[] dp = new int[s.length() + 1];
        Arrays.fill(dp, -1);
        return ways(0, s, dp);
    }
    public static void main(String[] args) throws Exception {}
}