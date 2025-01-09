class Solution {
    unordered_map<int, int> lookup;
public:
    int superEggDrop(int k, int n) {
        if(k == 1) return n;
        if(!n) return 0;
        if(lookup.find(n * 200 + k) == lookup.end()) {
            int low = 1, high = n;
            while(low + 1 < high) {
                int mid = (low + high) >> 1, nummoves1 = superEggDrop(k - 1, mid - 1), nummoves2 = superEggDrop(k, mid);
                if(nummoves1 < nummoves2) low = mid;
                else if(nummoves1 > nummoves2) high = mid;
                else {
                    low = mid;
                    high = mid;
                    break;
                }
            }
            lookup[n * 200 + k] = 1 + min(max(superEggDrop(k - 1, low - 1), superEggDrop(k, n - low)), max(superEggDrop(k - 1, high - 1), superEggDrop(k, n - high)));
        }
        return lookup[n * 200 + k];
    }
};
