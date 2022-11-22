import java.util.*;
class Trie {
    public Trie[] word;
    public boolean isEnd;
    public Trie() {
        word = new Trie[26];
        for(int i = 0; i < 26; i++)
            word[i] = null;
        isEnd = false;
    }
    public void insert(String key) {
        Trie curr = this;
        for(int i = 0; i < key.length(); i++) {
            int index = key.charAt(i) - 'a';
            if(curr.word[key.charAt(i) - 'a'] == null) curr.word[key.charAt(i) - 'a'] = new Trie();
            curr = curr.word[key.charAt(i) - 'a'];
        }
        curr.isEnd = true;
    }
    public Trie searchNode(char key, Trie curr) { return curr.word[key - 'a']; }
}
class Solution {
    private HashSet<Integer> idxSeen = new HashSet<Integer>();
    private boolean validWordBreak(Trie root, int idx, String str) {
        if(idx == str.length()) return true;
        if(idxSeen.contains(idx)) return false;
        Trie curr = root;
        idxSeen.add(idx);
        for(int i = idx; i < str.length(); i++) {
            curr = curr.searchNode(str.charAt(i), curr);
            if(curr == null) return false;
            if(curr.isEnd == true && validWordBreak(root, i + 1, str)) return true;
        }
        return false;
    }
    public boolean wordBreak(String s,
                        List<String> wordDict) {
        Trie root = new Trie();
        for(String word: wordDict)
            root.insert(word);
        return validWordBreak(root, 0, s);
    }
    public static void main(String[] args) throws Exception {}
}