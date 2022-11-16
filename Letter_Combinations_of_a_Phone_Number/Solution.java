import java.util.*;
class Solution {
    private static final Map<Character, List<Character>> digitMap = Map.of(
			'0', List.of(), 
			'1', List.of(), 
			'2', List.of('a', 'b', 'c'), 
			'3', List.of('d', 'e', 'f'), 
			'4', List.of('g', 'h', 'i'), 
			'5', List.of('j', 'k', 'l'), 
			'6', List.of('m', 'n', 'o'), 
			'7', List.of('p', 'q', 'r', 's'), 
			'8', List.of('t', 'u', 'v'), 
			'9', List.of('w', 'x', 'y', 'z')
	);
    public static List<String> letterCombinations(String digits) {
        LinkedList<String> result = new LinkedList<>();
        if (digits == null || digits.length() == 0) {
            return result;
        }

        result.add("");

        while (result.peek().length() < digits.length()) {
            String cur = result.poll();
            for (char c : digitMap.get(digits.charAt(cur.length()))) {
                result.add(cur + c);
            }
        }

        return result;
    }
    public static void main(String[] args) throws Exception {}
}