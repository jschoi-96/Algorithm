class Solution {
    int [] dx = {1,0,-1,0};
    int [] dy = {0,1,0,-1};

    int n, m;
    boolean [][] visited;
    int [][] dist;
    Queue<int []> firstQueue = new LinkedList<>();
    public int shortestBridge(int[][] grid) {
        n = grid.length; 
        m = grid[0].length;

        visited = new boolean[n][m];
        dist = new int[n][m];

        boolean flag = false;
        for(int i = 0; i < n ;i++){
            if (flag) break;
            for(int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    visited[i][j] = true;
                    bfs(grid, i, j);
                    flag = true;
                    break;
                }
            }
        }

         int cnt = 0;
        while (!firstQueue.isEmpty()) {
            int size = firstQueue.size();
            for (int i = 0; i < size; i++) {
                int[] cur = firstQueue.poll();
                int x = cur[0];
                int y = cur[1];

                for (int dir = 0; dir < 4; dir++) {
                    int nx = x + dx[dir];
                    int ny = y + dy[dir];

                    if (nx < 0 || ny < 0 || nx >= n || ny >= m || visited[nx][ny]) continue;

                    if (grid[nx][ny] == 1) return cnt;

                    visited[nx][ny] = true;
                    firstQueue.add(new int[]{nx, ny});
                }
            }
            cnt++;
        }

        return 1;
    }

    public void bfs(int [][] grid, int i, int j) {
        Queue<int []> q = new LinkedList<>();
        q.add(new int[]{i,j});
        visited[i][j] = true;

        while(!q.isEmpty()) {
            int [] cur = q.poll();
            int x = cur[0];
            int y = cur[1];
            firstQueue.add(new int[]{x,y}); // 첫번째 섬의 좌표들을 저장 
            
            for(int dir = 0; dir < 4; dir++) {
                int nx = x + dx[dir];
                int ny = y + dy[dir];
                if (nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
                if (visited[nx][ny] || grid[nx][ny] == 0) continue;

                visited[nx][ny] = true;
                q.add(new int[]{nx,ny});
            }
        }
    }
}