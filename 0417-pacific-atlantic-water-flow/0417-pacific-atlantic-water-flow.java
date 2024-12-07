class Solution {
    // 1. 모든 지점에서 bfs를 돌리기? -> 시간복잡도 터질듯
    
    static int [] dx = {1,0,-1,0};
    static int [] dy = {0,1,0,-1};
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int n = heights.length; // 높이
        int m = heights[0].length; // 길이

        Queue<int []> pacificQ = new LinkedList<>();
        Queue<int []> atlanticQ = new LinkedList<>();

        boolean [][] visited_p = new boolean[n][m];
        boolean [][] visited_a = new boolean[n][m];

        // 높이
        for(int i = 0; i < n; i++) {
            pacificQ.add(new int[]{i,0});
            atlanticQ.add(new int[]{i, m-1});
        }

        // 길이
        for(int i = 0; i < m; i++) {
            pacificQ.add(new int[]{0,i});
            atlanticQ.add(new int[]{n-1, i});
        }

        List<List<Integer>> res = new ArrayList<>();

        bfs(heights, pacificQ, visited_p);
        bfs(heights, atlanticQ, visited_a);
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if (visited_p[i][j] && visited_a[i][j]) {
                    res.add(Arrays.asList(i,j));
                }
            }
        }
        return res;
    }
    
    public void bfs(int[][] heights, Queue<int[]> q, boolean [][] visited) {
        while(!q.isEmpty()) {
            int [] cur = q.poll();
            int x = cur[0];
            int y = cur[1];
            visited[x][y] = true;

            for(int dir = 0; dir < 4; dir++) {
                int nx = x + dx[dir];
                int ny = y + dy[dir];
                if (nx < 0 || nx >= heights.length || ny < 0 || ny >= heights[0].length) continue;
                if (visited[nx][ny] || heights[nx][ny] < heights[x][y]) continue;
                visited[nx][ny] = true;
                q.add(new int[]{nx,ny});
            }
        }
    }
}