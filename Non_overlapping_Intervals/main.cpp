#include<bits/stdc++.h>

using namespace std;

class Solution {
public:
    int eraseOverlapIntervals(vector<vector<int>>& intervals) {
        if(intervals.size() == 1) return 0;
        int prev = 0, curr = 1, count = intervals.size() - 1;
        sort(intervals.begin(), intervals.end(), [](vector<int> &a, vector<int> &b) {
            return a[1] < b[1];
        });
        while(curr < intervals.size()) {
            if(intervals[prev][1] <= intervals[curr][0]) {
                prev = curr;
                count--;
            }
            curr++;
        }
        return count;
    }
};

int main() {}
