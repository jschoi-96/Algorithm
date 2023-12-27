풀이 방법
1. 배열을 순회하며 숫자가 '1'이고, 방문처리가 되어있지 않을 때 큐에 넣는다.
  - 해당 좌표를 방문처리 해주고, ans값을 하나 더해준다.
2. 큐가 빌때까지 루프를 돌면서 현재 좌표의 동서남북을 확인하며 조건을 확인한다.
  - 범위를 초과하거나 0보다 작은 경우
  - 방문처리가 되어있거나, 숫자가 '0'인 경우는 넘어가준다.
3. 해당 좌표에서 더이상 방문할 곳이 없다면, while문을 빠져나가고 다시 이중 포문이 돌아간다.
  - 다시 1 조건을 확인.

class Solution {
    public int numIslands(char[][] grid) {
        Queue<int []> queue = new LinkedList<>();
        boolean [][] visited = new boolean[302][302];
        int [] dx = {1,0,-1,0};
        int [] dy = {0,1,0,-1};
        int m = grid.length; int n = grid[0].length;
        int ans = 0;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                char target = grid[i][j];
                if (target == '1' && visited[i][j] == false) {
                    queue.add(new int[] {i,j});
                    visited[i][j] = true;
                    ans++;
                }

                while(!queue.isEmpty()) {
                    int [] cur = queue.poll(); // delete from queue
                    int x = cur[0];
                    int y = cur[1];
                    for(int dir = 0; dir < 4; dir++) {
                        int nx = x + dx[dir];
                        int ny = y + dy[dir];

                        if (nx < 0 || ny < 0 || nx >= m || ny >= n) continue;
                        if (visited[nx][ny] || grid[nx][ny] == '0') continue;
                        queue.add(new int[] {nx,ny});
                        visited[nx][ny] = true;
                    }
                }
            }
        }
        return ans;
    }
}
