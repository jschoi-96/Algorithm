import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[] dx = {1, 0, -1, 0, -1 ,-1, 1, 1};
    static int[] dy = {0, 1, 0, -1, -1, 1, -1, 1};
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int w = Integer.parseInt(st.nextToken());
            int h = Integer.parseInt(st.nextToken());

            if (w == 0 && h == 0) break;

            int[][] board = new int[h][w];
            for (int i = 0; i < h; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < w; j++) {
                    board[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            bfs(board);
        }
        System.out.println(sb);
    }

    public static void bfs(int[][] board) {
        int n = board.length, m = board[0].length;
        // land -> 1, sea -> 0
        boolean[][] visited = new boolean[n][m];
        Queue<int[]> q = new LinkedList<>();

        int cnt = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if (!visited[i][j] && board[i][j] == 1) {
                    cnt++;
                    q.add(new int[]{i, j});
                    while (!q.isEmpty()) {
                        int[] cur = q.poll();
                        int x = cur[0], y = cur[1];
                        for(int dir = 0; dir < 8; dir++) {
                            int nx = x + dx[dir], ny = y + dy[dir];
                            if (nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
                            if (visited[nx][ny] || board[nx][ny] == 0) continue;
                            visited[nx][ny] = true;
                            q.add(new int[]{nx, ny});
                        }
                    }
                }
            }
        }
        sb.append(cnt).append("\n");
    }
}
