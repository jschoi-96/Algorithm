import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
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
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        board = new int[n][m];

        for (int i = 0; i < n; i++) {
            String input = br.readLine();
            for (int j = 0; j < m; j++) {
                board[i][j] = input.charAt(j) - '0';
            }
        }

        bfs();
    }

    public static void bfs() {
        PriorityQueue<Node> pq = new PriorityQueue<>((a,b) -> a.cnt - b.cnt);
        pq.add(new Node(0, 0, 0));

        int[][] dist = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                dist[i][j] = Integer.MAX_VALUE;
            }
        }
        dist[0][0] = 0;

        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            int x = cur.x;
            int y = cur.y;
            int cnt = cur.cnt;

            if (x == n - 1 && y == m - 1) {
                System.out.println(cnt);
                return;
            }

            for(int dir = 0; dir < 4; dir++) {
                int nx = x + dx[dir];
                int ny = y + dy[dir];

                if (nx < 0 || ny < 0 || nx >= n || ny >= m) continue;

                if (board[nx][ny] == 1) {
                    if (dist[nx][ny] > cnt + 1) {
                        dist[nx][ny] = cnt + 1;
                        pq.add(new Node(nx, ny, cnt + 1));
                    }
                }

                else {
                    if (dist[nx][ny] > cnt) {
                        dist[nx][ny] = cnt;
                        pq.add(new Node(nx, ny, cnt));
                    }
                }
            }
        }
    }

    public static class Node {
        int x;
        int y;
        int cnt;
        public Node(int x, int y, int cnt) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }
    }
}