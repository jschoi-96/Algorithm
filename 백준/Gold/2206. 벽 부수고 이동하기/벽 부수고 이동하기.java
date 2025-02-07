import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int n, m;
    static int [][] board;
    static boolean [][][] visited;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        board = new int[n][m];
        visited = new boolean[n][m][2];

        for(int i = 0; i < n; i++) {
            String input = br.readLine();
            for(int j = 0; j < m; j++) {
                board[i][j] = input.charAt(j) - '0';
            }
        }

        Queue<Point> q = new LinkedList<>();
        q.add(new Point(0,0,1,false));
        visited[0][0][0] = true;

        while (!q.isEmpty()) {
            Point cur = q.poll();
            int x = cur.x;
            int y = cur.y;

            if (x == n - 1 && y == m - 1) {
                System.out.println(cur.dist);
                return;
            }

            boolean used = cur.used;
            for(int dir = 0; dir < 4; dir++) {
                int nx = x + dx[dir];
                int ny = y + dy[dir];
                if (nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
                int nxt = cur.dist + 1;

                if (board[nx][ny] == 1) { // 벽을 만났을 때
                    if (!used) { // 부순적이 없는 경우에 방문처리
                        visited[nx][ny][1] = true;
                        q.add(new Point(nx, ny, nxt, true));
                    }
                }

                else if (board[nx][ny] == 0) { // 빈칸을 지나는경우
                    if (!used && !visited[nx][ny][0]) { // 벽을 한번도 부순적이 없는 경우
                        q.add(new Point(nx, ny, nxt, false));
                        visited[nx][ny][0] = true;
                    }

                    else if (used && !visited[nx][ny][1]) { // 벽을 부순적이 있는 경우
                        q.add(new Point(nx, ny, nxt, true));
                        visited[nx][ny][1] = true;
                    }
                }
            }
        }

//        for(int i = 0; i < n; i++) {
//            for(int j = 0; j < m; j++) {
//                System.out.print(dist[i][j] + " ");
//            }
//            System.out.println();
//        }
        System.out.println(-1);
    }

    public static class Point {
        int x, y, dist;
        boolean used;
        public Point(int x, int y, int dist, boolean used){
            this.x = x;
            this.y = y;
            this.dist = dist;
            this.used = used;
        }
    }
}
