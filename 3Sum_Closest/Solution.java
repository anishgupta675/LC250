import java.util.*;
class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int n = nums.length, ans = 0, dist = Integer.MAX_VALUE, l = 0, r = n - 1, num = nums[0];
        for(int i = 0; i < n; i++) {
            l = i + 1;
            r = n - 1;
            num = nums[i];
            while(l < r) {
                if(nums[l] + nums[r] + num > target) {
                    if(Math.abs(nums[l] + nums[r] + num - target) < dist) {
                        dist = Math.abs(nums[l] + nums[r] + num - target);
                        ans = nums[l] + nums[r] + num;
                    }
                    r--;
                } else if(nums[l] + nums[r] + num < target) {
                    if(Math.abs(nums[l] + nums[r] + num - target) < dist) {
                        dist = Math.abs(nums[l] + nums[r] + num - target);
                        ans = nums[l] + nums[r] + num;
                    }
                    l++;
                } else if(nums[l] + nums[r] + num == target) return target;
            }
        }
        return ans;
    }
    public static void main(String[] args) throws Exception {}
}