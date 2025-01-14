class Solution {
    int[] dx = {1, 0, -1, 0};
    int[] dy = {0, 1, 0, -1};

    int n, m;
    boolean[][] visited;
    Queue<int[]> firstQueue = new LinkedList<>();

    public int shortestBridge(int[][] grid) {
        n = grid.length;
        m = grid[0].length;
        visited = new boolean[n][m];

        // 첫 번째 섬을 BFS로 탐색하여 큐에 저장
        boolean found = false;
        for (int i = 0; i < n; i++) {
            if (found) break;
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    bfs(grid, i, j); // 첫 번째 섬의 좌표를 큐에 저장
                    found = true;
                    break;
                }
            }
        }

        // 두 번째 섬까지의 최단 거리 계산
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

                    // 두 번째 섬에 도달
                    if (grid[nx][ny] == 1) return cnt;

                    // 물 영역 확장
                    visited[nx][ny] = true;
                    firstQueue.add(new int[]{nx, ny});
                }
            }
            cnt++;
        }

        return -1; // 두 번째 섬을 찾지 못한 경우
    }

    public void bfs(int[][] grid, int i, int j) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{i, j});
        visited[i][j] = true;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0];
            int y = cur[1];
            firstQueue.add(new int[]{x, y}); // 첫 번째 섬의 좌표를 저장

            for (int dir = 0; dir < 4; dir++) {
                int nx = x + dx[dir];
                int ny = y + dy[dir];

                if (nx < 0 || ny < 0 || nx >= n || ny >= m || visited[nx][ny] || grid[nx][ny] == 0) continue;

                visited[nx][ny] = true;
                q.add(new int[]{nx, ny});
            }
        }
    }
}