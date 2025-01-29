class Solution:
    def groupAnagrams(self, strs: List[str]) -> List[List[str]]:
        hmap = {}
        for i in range(len(strs)):
            word = ''.join(sorted(strs[i]))
            if word in hmap:
                hmap[word].append(strs[i])
            else:
                hmap[word] = [strs[i]]
        res = []
        for i in hmap.values():
            res.append(i)
        return res
