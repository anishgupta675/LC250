import java.util.*;
class Solution {
    public int getMax(int[] nums, int low, int high) {
        int max_val = nums[low];
        for(int i = low; i < high + 1; i++)
            max_val = Math.max(max_val, i + nums[i]);
        return max_val;
    }
    public int jump(int[] nums) {
        int low = 0, high = 0, count = 0, n = nums.length;
        while(high < n - 1) {
            int max_val = getMax(nums, low, high);
            low = high + 1;
            high = max_val;
            count++;
        }
        return count;
    }
    public static void main(String[] args) throws Exception {}
}