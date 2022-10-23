import java.util.*;
class Solution {
    public int[] sortedSquares(int[] nums) {
        int i = 0, j = nums.length - 1;
        int[] res = new int[nums.length];
        for(int k = nums.length - 1; k >= 0; k--) {
            if(Math.abs(nums[i]) > Math.abs(nums[j])) {
                res[k] = nums[i] * nums[i];
                i++;
            } else {
                res[k] = nums[j] * nums[j];
                j--;
            }
        }
        return res;
    }
    public static void main(String[] args) throws Exception {}
}