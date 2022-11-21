import java.util.*;
class Solution {
    public int[] countBits(int n) {
        int[] ans = new int[n + 1];
        for(int i = 1; i <= n; i++) {
            int count = (i&(i-1));
            ans[i] = ans[count] + 1;
        }
        return ans;
    }
    public static void main(String[] args) throws Exception {}
}