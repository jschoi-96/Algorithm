class Solution {
    // current라는 현재값을
    static boolean [] visited;
    static int ans = 0;
    public int solution(int k, int[][] dungeons) {
        visited = new boolean[dungeons.length];
        dfs(k, dungeons, 0);
        return ans;
    }
    
    public void dfs(int k, int[][] dungeons, int count) {
        ans = Math.max(ans, count);
        
        for(int i = 0; i < dungeons.length; i++) {
            if (!visited[i] && k >= dungeons[i][0]) {
                visited[i] = true;
                dfs(k - dungeons[i][1], dungeons, count + 1);
                visited[i] = false;
            }
        }
    }
}