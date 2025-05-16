import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        char[][] board = new char[n][m];
        for (int i = 0; i < n; i++) {
            String input = br.readLine();
            for (int j = 0; j < m; j++) {
                board[i][j] = input.charAt(j);
            }
        }

        boolean[][][] visited = new boolean[n][m][k+1];
        Queue<Point> q = new LinkedList<>();

        visited[0][0][0] = true;
        q.add(new Point(0, 0, 0, 1));

        // 1000 * 1000 * 10 * 4 = 4000 0000
        while (!q.isEmpty()) {
            Point cur = q.poll();
            int x = cur.x;
            int y = cur.y;
            int currentK = cur.cur; // 현재 벽을 부순 횟수.
            int dist = cur.dist;

            if (x == n - 1 && y == m - 1) {
                System.out.println(dist);
                return;
            }

            for(int dir = 0; dir < 4; dir++) {
                int nx = x + dx[dir];
                int ny = y + dy[dir];
                if (nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
                if (board[nx][ny] == '0' && !visited[nx][ny][currentK]) {
                    q.add(new Point(nx, ny, currentK, dist + 1));
                    visited[nx][ny][currentK] = true;
                }

                else if (board[nx][ny] == '1' && currentK < k && !visited[nx][ny][currentK + 1]) {
                    q.add(new Point(nx, ny, currentK + 1, dist + 1));
                    visited[nx][ny][currentK + 1] = true;
                }
            }
        }

        System.out.println(-1);
    }

    public static class Point {
        int x;
        int y;
        int cur;
        int dist;
        public Point(int x, int y, int cur, int dist) {
            this.x = x;
            this.y = y;
            this.cur = cur;
            this.dist = dist;
        }
    }
}
