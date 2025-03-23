#include<bits/stdc++.h>

using namespace std;

class Solution {
    vector<int> mergeNums(vector<int> &a, vector<int> &b) {
        vector<int> res;
        int i = 0, j = 0;
        while(i < a.size() || j < b.size()) {
            if(i == a.size()) res.push_back(b[j++]);
            else if(j == b.size() || a[i] > b[j]) res.push_back(a[i++]);
            else if(a[i] < b[j]) res.push_back(b[j++]);
            else {
                int k = 0;
                while(i + k < a.size() && j + k < b.size() && a[i + k] == b[j + k])
                    k++;
                if(i + k >= a.size()) res.push_back(b[j++]);
                else if(j + k >= b.size()) res.push_back(a[i++]);
                else if(a[i + k] > b[j + k]) res.push_back(a[i++]);
                else res.push_back(b[j++]);
            }
        }
        return res;
    }
    vector<int> getLargestNum(vector<int> &nums, int k) {
        vector<int> res;
        for(int i = 0; i < nums.size(); i++) {
            while(!res.empty() && nums[i] > res.back() && nums.size() - i - 1 >= k - res.size())
                res.pop_back();
            if(res.size() < k) res.push_back(nums[i]);      
        }
        return res;
    }
public:
    vector<int> maxNumber(vector<int>& nums1, vector<int>& nums2, int k) {
        vector<int> res(k, 0);
        for(int k1 = 0; k1 <= k; k1++) {
            int k2 = k - k1;
            if(k1 > nums1.size() || k2 > nums2.size()) continue;
            auto num1 = getLargestNum(nums1, k1);
            auto num2 = getLargestNum(nums2, k2);
            auto merged = mergeNums(num1, num2);
            if(merged > res) res = merged;
        }
        return res;
    }
};

int main() {}
