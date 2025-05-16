import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
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

        boolean[][][][] visited = new boolean[n][m][k+1][2]; // k+1번까지 허용, 밤낮
        ArrayDeque<Point> q = new ArrayDeque<>();

        visited[0][0][0][0] = true; // 0: 낮, 1: 밤
        q.add(new Point(0, 0, 1,0, true));

        while (!q.isEmpty()) {
            Point p = q.poll();
            int x = p.x;
            int y = p.y;
            int dist = p.dist;
            int cnt = p.cnt;
            boolean isDay = p.isDay;

            if (x == n - 1 && y == m - 1) {
                System.out.println(dist);
                return;
            }

            //isDay = !isDay; // 칸이 먼저 바뀌어야함

            for(int dir = 0; dir < 4; dir++) {
                int nx = x + dx[dir];
                int ny = y + dy[dir];
                if (nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
                if (board[nx][ny] == '0') { // 벽을 만나지 않았을 때
                    if (isDay && !visited[nx][ny][cnt][0]) { // 낮인 경우
                        visited[nx][ny][cnt][0] = true;
                        q.add(new Point(nx, ny, dist + 1, cnt, !isDay));
                    }

                    else if (!isDay && !visited[nx][ny][cnt][1]) { // 밤인 경우
                        visited[nx][ny][cnt][1] = true;
                        q.add(new Point(nx, ny, dist + 1, cnt, !isDay));
                    }
                }

                else { // 벽을 만나버렸을 때
                    if (isDay && cnt < k && !visited[nx][ny][cnt + 1][0]) { // 낮이고, 방문하지 않았고 카운트가 k미만인 경우에만!
                        visited[nx][ny][cnt + 1][0] = true;
                        q.add(new Point(nx, ny, dist + 1, cnt + 1, !isDay));
                    }

                    else if (!isDay && cnt < k && !visited[nx][ny][cnt + 1][1]) {
                        visited[nx][ny][cnt + 1][1] = true;
                        q.add(new Point(x, y, dist + 1, cnt, !isDay));
                    }
                }
            }
        }
        System.out.println(-1);

    }

    public static class Point {
        int x;
        int y;
        int dist;
        int cnt;
        boolean isDay;
        public Point(int x, int y, int dist, int cnt, boolean isDay) {
            this.x = x;
            this.y = y;
            this.dist = dist;
            this.cnt = cnt;
            this.isDay = isDay;
        }
    }
}