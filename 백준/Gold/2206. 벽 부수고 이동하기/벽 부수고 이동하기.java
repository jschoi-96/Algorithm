import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static char[][] board;
    static boolean[][][] visited;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        board = new char[n][m];
        visited = new boolean[n][m][2];
        for (int i = 0; i < n; i++) {
            String input = br.readLine();
            for (int j = 0; j < m; j++) {
                board[i][j] = input.charAt(j);
            }
        }

        // (0,0) ~ (n,m)까지 이동, 최단거리
        Queue<Point> q = new LinkedList<>();

        // (0,0)에서 출발 및 방문처리
        q.add(new Point(0, 0, 1, true));

        // 0: 벽을 아직 부순 적 없음, 1: 벽을 부순 상태
        visited[0][0][0] = true;

        while (!q.isEmpty()) {
            Point cur = q.poll();
            int x = cur.x;
            int y = cur.y;
            int dist = cur.dist;
            boolean isPossible = cur.isPossible;

            if (x == n - 1 && y == m - 1) {
                System.out.println(dist);
                return;
            }

            for(int dir = 0; dir < 4; dir++) {
                int nx = x + dx[dir];
                int ny = y + dy[dir];
                if (nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
                if (board[nx][ny] == '0') {
                    if (!visited[nx][ny][0] && isPossible) { // 벽을 부순 내역이 없는 경우
                        q.add(new Point(nx, ny, dist + 1, true));
                        visited[nx][ny][0] = true;
                    }

                    else if (!visited[nx][ny][1] && !isPossible) { // 부순 경우
                        q.add(new Point(nx, ny, dist + 1, false));
                        visited[nx][ny][1] = true;
                    }
                }

                else { // 벽인 경우
                    if (!visited[nx][ny][0] && isPossible) {
                        q.add(new Point(nx, ny, dist + 1, false));
                        visited[nx][ny][0] = true; // 이제 방문한것으로 표시를 해줘야 함.
                    }
                    // visited[nx][ny][1]의 경우에는 체크하지 않는데, 어짜피 못지나가기 때문.
                }
            }
        }

        if (!visited[n-1][m-1][0] || visited[n-1][m-1][1]) {
            System.out.println(-1);
        }
    }

    static class Point {
        int x;
        int y;
        int dist;
        boolean isPossible;

        public Point(int x, int y, int dist, boolean isPossible) {
            this.x = x;
            this.y = y;
            this.dist = dist;
            this.isPossible = isPossible;
        }
    }
}
