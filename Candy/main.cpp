#include<bits/stdc++.h>

using namespace std;

class Solution {
public:
    int candy(vector<int>& ratings) {
        int totalCandies = ratings.size(), i = 1;
        while(i < ratings.size()) {
            if(ratings[i] == ratings[i - 1]) {
                i++;
                continue;
            }
            int currentPeak = 0;
            while(i < ratings.size() && ratings[i] > ratings[i - 1]) {
                currentPeak++;
                totalCandies += currentPeak;
                i++;
            }
            if(i == ratings.size()) return totalCandies;
            int currentValley = 0;
            while(i < ratings.size() && ratings[i] < ratings[i - 1]) {
                currentValley++;
                totalCandies += currentValley;
                i++;
            }
            totalCandies -= min(currentPeak, currentValley);
        }
        return totalCandies;
    }
};

int main() {}
