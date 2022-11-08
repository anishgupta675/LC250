import java.util.*;
class Solution {
    public int firstMissingPositive(int[] nums) {
        if(nums.length==1){
            if(nums[0]!=1) return 1;
            else return 2;
        }
        
        int n=nums.length;
        boolean isOne=false;
        
        for(int i=0;i<nums.length;i++){
            if(nums[i]==1) isOne=true;
            if(nums[i]<1 || nums[i]>n) nums[i]=1;
        }
        
        if(!isOne) return 1;
        
        for(int i=0;i<nums.length;i++){
            int index=Math.abs(nums[i])-1;
            
            if(nums[index]<=0) continue;
            else nums[index]*=-1;
        }
        
        for(int i=0;i<nums.length;i++){
            if(nums[i]>0) return i+1;
        }
        return n+1;
    }
    public static void main(String[] args) throws Exception {}
}