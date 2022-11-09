import java.util.*;
class Solution {
    public int solve(int[] prices)
    {
        int n= prices.length;
        
        int[][][] dp = new int[n+1][2][3];
        for(int[][] row : dp)
            for(int[] row2 : row)
                Arrays.fill(row2,0);
        
        for(int i=n-1;i>=0;i--)
        {
            for(int val=0;val<2;val++)
            {
                for(int count = 1;count<=2;count++)
                {
                    if(val==0)
                        dp[i][val][count] = Math.max(-prices[i]+dp[i+1][1][count],0+dp[i+1][0][count]);
        
                    if(val==1)
                        dp[i][val][count] = Math.max(prices[i]+dp[i][0][count-1],0+dp[i+1][1][count]);
                }
            }
        }
        
        return dp[0][0][2];
    }
    public int maxProfit(int[] prices) {
        return solve(prices);
    }
    public static void main(String[] args) throws Exception {}
}