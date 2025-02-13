import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int n, m, k;
    static int [][] board;
    static boolean [][][] visited;
    static int [][] dist;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static Queue<Point> q = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        board = new int[n][m];
        dist = new int[n][m];
        visited = new boolean[n][m][k+1]; // 0 ~ k개 벽 부숨

        for (int i = 0; i < n; i++) {
            String input = br.readLine();
            for (int j = 0; j < m; j++) {
                board[i][j] = input.charAt(j) - '0';
                dist[i][j] = -1;
            }
        }

        visited[0][0][0] = true; // (0,0)은 항상 0
        q.add(new Point(0, 0, 0));
        dist[0][0] = 1;
        bfs();
    }

    public static void bfs() {
        while (!q.isEmpty()) {
            Point p = q.poll();
            int x = p.x;
            int y = p.y;
            int cnt = p.cnt;

            if (x == n - 1 && y == m - 1) {
                System.out.println(dist[x][y]);
                return;
            }

            for(int dir = 0; dir < 4; dir++) {
                int nx = x + dx[dir];
                int ny = y + dy[dir];
                if (nx < 0 || ny < 0 || nx >= n || ny >= m) continue;

                if (board[nx][ny] == 0) { // 빈칸일 때
                    if (cnt < k && !visited[nx][ny][cnt]) { // k개 미만으로 부쉈을 때
                        visited[nx][ny][cnt] = true;
                        q.add(new Point(nx, ny, cnt));
                    }

                    else if (cnt == k && !visited[nx][ny][cnt]) { // k개 부쉈을 때
                        visited[nx][ny][cnt] = true;
                        q.add(new Point(nx, ny, cnt));
                        // System.out.println(nx + " " + ny);
                    }
                }

                else { // 벽인 경우
                    if (cnt <= k && !visited[nx][ny][cnt]) { // k개 미만으로 부쉈을 때, 부수고 나아간다
                        visited[nx][ny][cnt] = true;
                        q.add(new Point(nx, ny, cnt + 1));
                    }
                }
                dist[nx][ny] = dist[x][y] + 1;
                // System.out.println("x: " + x + ", y: " + y + ", cnt: " + cnt);
            }
        }
        System.out.println(-1);
    }

    public static class Point {
        int x;
        int y;
        int cnt;
        public Point(int x, int y, int cnt) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }
    }
}
