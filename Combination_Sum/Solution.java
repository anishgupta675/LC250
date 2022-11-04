import java.util.*;
class Solution {
    List<List<Integer>> ans=new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        helper(candidates,target,0,new ArrayList<>());
        return ans;
    }
    public void helper(int [] arr,int sum,int ind,List<Integer> temp){
        if(ind==arr.length){
            return;
        }
        
        if(arr[ind]==sum){
            ArrayList<Integer> temp2=new ArrayList<>();
            temp2.addAll(temp);
            temp2.add(arr[ind]);
            ans.add(temp2);
            return;
        }
        if(arr[ind]>sum){
            return;
        }
        
        helper(arr,sum,ind+1,temp);
        
        ArrayList<Integer> temp2=new ArrayList<>();
        temp2.addAll(temp);
        temp2.add(arr[ind]);
        helper(arr,sum-arr[ind],ind,temp2);
    }
    public static void main(String[] args) throws Exception {}
}