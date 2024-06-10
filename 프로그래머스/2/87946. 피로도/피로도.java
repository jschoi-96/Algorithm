class Solution {
    static boolean [] visited;
    static int answer = 0;
    public int solution(int k, int[][] dungeons) {
        visited = new boolean[k];
        dfs(k, dungeons, visited, 0);
        return answer;
    }
    
    public void dfs(int cur, int [][] dungeons, boolean [] visited, int depth) {
        answer = Math.max(answer, depth);
        for(int i = 0; i < dungeons.length; i++) {
            int min = dungeons[i][0];
            int consume = dungeons[i][1];
            if (!visited[i] && cur >= min) { // 방문하지 않았고, 현재 피로도가 최소 필요 피로도보다 높을 떄
                visited[i] = true;
                dfs(cur - consume, dungeons, visited, depth + 1);
                visited[i] = false;
            }
        }
        
        //System.out.println(cnt);
    }
}