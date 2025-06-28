import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int n, m;
    static int[][] board;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        board = new int[n][m];
        for (int i = 0; i < n; i++) {
            String input = br.readLine();
            for (int j = 0; j < m; j++) {
                board[i][j] = input.charAt(j) - '0';
            }
        }

        boolean[][][] visited = new boolean[n][m][2]; // [2] -> 벽을 부쉈는지 판단 요소

        Queue<Point> q = new LinkedList<>();
        q.add(new Point(0, 0, 0, false));
        visited[0][0][0] = true; // 0 -> 벽을 안부순 상태, 1 -> 부순 상태

        while (!q.isEmpty()) {
            Point p = q.poll();
            int x = p.x, y = p.y, dist = p.dist;
            boolean isBroke = p.isBroke;

            if (x == n - 1 && y == m - 1) {
                System.out.println(dist + 1);
                return;
            }

            for(int dir = 0; dir < 4; dir++) {
                int nx = x + dx[dir];
                int ny = y + dy[dir];
                if (nx < 0 || ny < 0 || nx >= n || ny >= m) continue;

                if (board[nx][ny] == 0) { // 이동할 수 있는 곳일 때
                    if (!isBroke && !visited[nx][ny][0]) {
                        q.add(new Point(nx, ny, dist + 1, false));
                        visited[nx][ny][0] = true;
                    }

                    else if (isBroke && !visited[nx][ny][1]) {
                        q.add(new Point(nx, ny, dist + 1, true));
                        visited[nx][ny][1] = true;
                    }
                }

                else { // 벽을 만난 경우
                    if (isBroke || visited[nx][ny][1]) continue; // 이미 부순 내역이 있거나 방문한 경우 스킵
                    q.add(new Point(nx, ny, dist + 1, true));
                }
            }
        }
        System.out.println(-1);
    }

    public static class Point {
        int x;
        int y;
        int dist;
        boolean isBroke;
        public Point(int x, int y, int dist, boolean isBroke) {
            this.x = x;
            this.y = y;
            this.dist = dist;
            this.isBroke = isBroke;
        }
    }
}
