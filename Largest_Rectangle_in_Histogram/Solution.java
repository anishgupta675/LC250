import java.util.*;
class Solution {
    public int largestRectangleArea(int[] heights) {
        int i,n=heights.length;
        int res=0;
        int tb,cur;
        Stack<Integer> s=new Stack<>();
        
        for(i=0;i<heights.length;i++)
        {
            while(!s.isEmpty()&&heights[s.peek()]>=heights[i])
            {
                tb=s.pop();
                cur=heights[tb]*(s.isEmpty()?i:i-s.peek()-1);
                res=Math.max(res,cur);
            }
            s.push(i);
        }
        
        while(!s.isEmpty())
        {
            tb=s.pop();
                cur=heights[tb]*(s.isEmpty()?n:n-s.peek()-1);
                res=Math.max(res,cur);
        }
        return(res);
    }
    public static void main(String[] args) throws Exception {}
}