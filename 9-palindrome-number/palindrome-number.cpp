class Solution {
public:
    bool isPalindrome(int x) {
        string res = to_string(x);
        
        int r = res.size() - 1;
        for(int l = 0; l < res.size(); l++){
            
            cout << res[l] << ' ' << res[r] << '\n';
            if (res[l] != res[r]){
                return false;
            }

            
            r--;
        }
        return true;
    }
};