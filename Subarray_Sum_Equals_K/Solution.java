import java.util.*;
class Solution {
    public int subarraySum(int[] nums, int k) {
        int[] sums = new int[nums.length + 1];
        int sum = 0;
        for (int i = 0; i < nums.length; i ++) {
            sum += nums[i];
            sums[i + 1] = sum;
        }
        int count = 0;
        for (int i = 0; i < nums.length; i ++) {
            int pre = sums[i];
            for (int j = i; j < nums.length; j ++) {
                int tmp = sums[j + 1] - pre;
                if (tmp == k) {
                    count ++;
                }
            }
        }
        return count;
    }
    public static void main(String[] args) throws Exception {}
}