import java.util.*;
class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        int n=nums.length;
        int x=1<<(n);
        for(int i=0;i<x;i++)
        {
            List<Integer> l = new ArrayList<>();
            for(int j=0;j<n;j++)
            {
                int y=(1<<j);
                if((i & y)>0)
                    l.add(nums[j]);
            }
            list.add(l);
        }
        return list;
    }
    public static void main(String[] args) throws Exception {}
}