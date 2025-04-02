class Solution {
    long [] dp;
    int n;
    public long mostPoints(int[][] questions) {
        n = questions.length;
        dp = new long[n];
        return dfs(0, questions);
    }

    public long dfs(int idx, int[][] questions) {
        if (idx >= n) {
            return 0;
        }

        if (dp[idx] != 0) return dp[idx];
        long skip = dfs(idx + 1, questions);
        long choose = questions[idx][0] + dfs(idx + 1 + questions[idx][1], questions);
        dp[idx] = Math.max(skip, choose);
        return dp[idx];
    }
}