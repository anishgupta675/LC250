import java.util.*;
class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> hmap = new HashMap<Integer, Integer>();
        for(int i = 0; i < nums.length; i++)
            hmap.put(nums[i], i);
        for(int i = 0; i < nums.length; i++)
            if(hmap.containsKey(Integer.valueOf(target - nums[i])) && i != hmap.get(Integer.valueOf(target - nums[i]))) return new int[] { i, hmap.get(Integer.valueOf(target - nums[i])) };
        return new int[] {};
    }
    public static void main() throws Exception {}
}