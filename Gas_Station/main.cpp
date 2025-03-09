#include<bits/stdc++.h>

using namespace std;

class Solution {
public:
    int canCompleteCircuit(vector<int>& gas, vector<int>& cost) {
        int gas_available = 0, gas_required = 0, starting_station = 0;
        for(int i = 0; i < gas.size(); i++) {
            gas_available = gas_available + gas[i] - cost[i];
            gas_required = gas_required + gas[i] - cost[i];
            if(gas_required < 0) {
                starting_station = i + 1;
                gas_required = 0;
            }
        }
        return (gas_available < 0) ? -1 : starting_station;
    }
};

int main() {}
