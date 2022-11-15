import java.util.*;
class Solution {
    public void combinations(int n , int k , List<List<Integer>> ans , List<Integer> temp){
        if(k == 0)
        {
            ans.add(new ArrayList(temp));
            return;
        }
        if(n == 0)
            return;
        

        combinations(n-1, k, ans,temp);
        

        temp.add(n);
        combinations(n-1,k-1,ans,temp);
        temp.remove(temp.size()-1);
    }
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        combinations(n,k,ans,temp);
        return ans;
    }
    public static void main(String[] args) throws Exception {}
}