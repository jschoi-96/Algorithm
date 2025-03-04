class Solution {
    boolean [] visited = new boolean[17];
    boolean flag = false;
    public boolean checkPowersOfThree(int n) {
        // 1 3 9 27
        dfs(n, 0, 0);
        return flag;
    }

    public void dfs(int n, int start, int sum) {
        if (sum == n) {
            flag = true;
            return;
        }

        for(int i = start; i <= 16; i++) {
            if (!visited[i]) {
                visited[i] = true;
                dfs(n, i + 1, sum + (int)Math.pow(3, i));
                visited[i] = false;
            }
        }
    }
}