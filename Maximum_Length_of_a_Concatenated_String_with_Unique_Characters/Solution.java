import java.util.*;
class Solution {
    public int maxLength(List<String> arr) {
        List<String> arr2 = new ArrayList<>();
        for (String str : arr)
            if (isSelfUnique(str)) arr2.add(str);
        return helper_backtracking1(arr2, 0, new int[26]);
    }
    private int helper_backtracking1(List<String> arr, int begin, int[] counter) {
        int count = 0;

        if (begin >= arr.size()) {
            for (int n : counter) if (n != 0) count++;
            return count;
        }


        Set<Integer> toBeRemoveSet = new HashSet<>();
        if (isContainAny(counter, arr.get(begin))){
            count = Math.max(count, helper_backtracking1(arr, begin + 1, counter));

            //remove prev
            for(char c : arr.get(begin).toCharArray()) {
                if (counter[c - 'a'] != 0) {
                    int idx = counter[c - 'a'] - 1;
                    if (toBeRemoveSet.add(idx))
                        removeFromSet(counter, arr.get(idx));
                }
            }
        }

        addToSet(counter, arr.get(begin), begin);
        count = Math.max(count, helper_backtracking1(arr, begin + 1, counter));
        removeFromSet(counter, arr.get(begin));

        for (int toBeRemoveIdx: toBeRemoveSet)
            addToSet(counter,arr.get(toBeRemoveIdx), toBeRemoveIdx);

        return count;
    }
    private boolean isSelfUnique(String str){
        Set<Character> strSet = new HashSet<>();
        for(char c : str.toCharArray())
            if (!strSet.add(c)) return false;
        return true;
    }
    private boolean isContainAny(int[] data, String str){
        for(char c : str.toCharArray())
            if (data[c - 'a'] != 0) return true;
        return false;
    }
    private void addToSet(int[] data, String str, int i){
        i++;
        for(char c : str.toCharArray()) data[c - 'a'] = i;
    }
    private void removeFromSet(int[] data, String str){
        for(char c : str.toCharArray()) data[c - 'a'] = 0;
    }
    public static void main(String[] args) throws Exception {}
}