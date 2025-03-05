class Solution {
    // n = 10만 
    long [] dp = new long[100002];
    public long coloredCells(int n) {
        // 1 -> 4 -> 8 -> 12
        dp[1] = 1;
        for(int i = 2; i <= n; i++) {
            dp[i] = dp[i-1] + 4 * (i-1);
        }
        return dp[n];
    }
}