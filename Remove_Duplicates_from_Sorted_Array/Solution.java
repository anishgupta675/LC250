import java.util.*;
class Solution {
    public int removeDuplicates(int[] nums) {
        if(nums.length < 2) return nums.length;
        int i = 1, count = 1, prev = nums[0];
        while(i < nums.length) {
            while(i < nums.length && nums[i] == prev) i++;
            if(i < nums.length) {
                prev = nums[i];
                nums[count++] = nums[i];
            }
        }
        return count;
    }
    public static void main(String[] args) throws Exception {}
}