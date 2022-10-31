import java.util.*;
class Solution {
 /* int getMax(int[] height) {
        int index = 0, max_val = height[0];
        for(int i = 0; i < height.length; i++) {
            if(height[i] > max_val) {
                max_val = height[i];
                index = i;
            }
        }
        return index;
    }
    int getSMax(int[] height) {
        int index = 0, max_val = height[0], first = getMax(height);
        for(int i = 0; i < height.length; i++) {
            if(height[i] > max_val && i != first) {
                max_val = height[i];
                index = i;
            }
        }
        return index;
    } */
    public int maxArea(int[] height) {
     /*   int fMax = getMax(height), sMax = getSMax(height), max_val = Math.min(height[height.length - 1], height[0]) * Math.abs(height.length - 1);
        for(int i = fMax; i >= 0; i--)
            max_val = Math.max(max_val, Math.min(height[i], height[fMax]) * (fMax - i));
        for(int i = fMax; i < height.length; i++)
            max_val = Math.max(max_val, Math.min(height[fMax], height[i]) * (i - fMax));
        return Math.max(max_val, Math.min(height[fMax], height[sMax]) * Math.abs(fMax - sMax)); */
     /* int max_val = 0;
        for(int i = 0; i < height.length; i++) {
            for(int j = 0; j < height.length; j++)
                max_val = Math.max(max_val, Math.min(height[j], height[i]) * Math.abs(j - i));
        }
        return max_val; */
        int first = 0, second = height.length - 1, max_val = 0;
        while(second - first > 0) {
            max_val = Math.max(max_val, Math.min(height[first], height[second]) * (second - first));
            if(height[first] >= height[second]) second--;
            else first++;
        }
        return max_val;
    }
    public static void main(String[] args) throws Exception {}
}