import java.util.*;
class Solution {
    public int maxProfit(int[] prices) {
        int min_val = Integer.MAX_VALUE, max_val = 0;
        for(int i = 0; i < prices.length; i++) {
            if(prices[i] < min_val) min_val = prices[i];
            else max_val = Math.max(max_val, prices[i] - min_val);
        }
        return max_val;
    }
    public static void main(String[] args) throws Exception {}
}