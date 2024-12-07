

public class Solution {

    // 1. 가장자리를 돌면서 O에서 BFS를 돌린다.
    // 2. BFS를 돌면서 가장자리에 도달하면 true, 아니면 false를 리턴한다.
    // 
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    public void solve(char[][] board) {
        int n = board.length;
        int m = board[0].length;
        boolean[][] visited = new boolean[n][m];

        for (int i = 1; i < n - 1; i++) {
            for (int j = 1; j < m - 1; j++) {
                if (board[i][j] == 'O' && !visited[i][j]) {
                    boolean isConnectedToEdge = bfs(i, j, board, visited);
                    if (!isConnectedToEdge) {
                        fillRegion(i, j, board);
                    }
                }
            }
        }
    }

    public boolean bfs(int i, int j, char[][] board, boolean[][] visited) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{i, j});
        visited[i][j] = true;

        boolean isEdge = false;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0], y = cur[1];

            // 가장자리에 도달하면 연결된 상태로 판단
            if (x == 0 || x == board.length - 1 || y == 0 || y == board[0].length - 1) {
                isEdge = true;
            }

            for (int dir = 0; dir < 4; dir++) {
                int nx = x + dx[dir];
                int ny = y + dy[dir];
                if (nx < 0 || nx >= board.length || ny < 0 || ny >= board[0].length) continue;
                if (visited[nx][ny] || board[nx][ny] == 'X') continue;
                q.add(new int[]{nx, ny});
                visited[nx][ny] = true;
            }
        }

        return isEdge;
    }

    public void fillRegion(int i, int j, char[][] board) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{i, j});
        board[i][j] = 'X';

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0];
            int y = cur[1];

            for (int dir = 0; dir < 4; dir++) {
                int nx = x + dx[dir];
                int ny = y + dy[dir];
                if (nx < 0 || nx >= board.length || ny < 0 || ny >= board[0].length) continue;
                if (board[nx][ny] == 'O') {
                    q.add(new int[]{nx,ny});
                    board[nx][ny] = 'X';
                }
            }
        }
    }
}