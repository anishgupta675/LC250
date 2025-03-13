#include<bits/stdc++.h>

using namespace std;

class Solution {
public:
    int minDeletions(string s) {
        int min_del = 0;
        unordered_set<int> uset;
        unordered_map<int, int> umap;
        for(int i = 0; i < s.length(); i++) umap[s[i]]++;
        for(auto i : umap) {
            if(uset.find(i.second) == uset.end()) uset.insert(i.second);
            else {
                while(uset.find(i.second) != uset.end() && i.second) {
                    i.second--;
                    min_del++;
                }
                uset.insert(i.second);
            }
        }
        return min_del;
    }
};

int main() {}
