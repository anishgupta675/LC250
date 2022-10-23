import java.util.*;
class Solution {
    public int pivotIndex(int[] nums) {
        int current_sum = 0;
        for(int i = 1; i < nums.length; i++)
            current_sum+= nums[i];
        if(current_sum == 0) return 0;
        for(int i = 1; i < nums.length; i++) {
            current_sum-= nums[i - 1] + nums[i];
            if(current_sum == 0) return i;
        }
        return -1;
    }
    public static void main(String[] args) throws Exception {}
}