#include<bits/stdc++.h>

using namespace std;

class Solution {
public:
    string removeKdigits(string num, int k) {
        int i = 0;
        string res = "";
        stack<char> st;
        while(i < num.length()) {
            while(k && !st.empty() && st.top() >= num[i]) {
                st.pop();
                k--;
            }
            st.push(num[i]);
            i++;
        }
        while(k--) st.pop();
        while(!st.empty()) {
            res+= st.top();
            st.pop();
        }
        reverse(res.begin(), res.end());
        while(res.length() > 1 && res[0] == '0') res.erase(0, 1);
        return (!res.compare("")) ? "0" : res;
    }
};

int main() {}
