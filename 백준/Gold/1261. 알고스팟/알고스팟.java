import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int m, n;
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
        PriorityQueue<Node> pq = new PriorityQueue<>((a,b) -> a.cost - b.cost);
        int[][] dist = new int[n][m];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                dist[i][j] = Integer.MAX_VALUE;
            }
        }

        pq.add(new Node(0, 0, 0));
        dist[0][0] = 0;

        while(!pq.isEmpty()) {
            Node cur = pq.poll();
            int x = cur.x;
            int y = cur.y;
            int cost = cur.cost;

            if (x == n - 1 && y == m - 1) {
                System.out.println(cost);
                return;
            }

            for(int dir = 0; dir < 4; dir++) {
                int nx = x + dx[dir];
                int ny = y + dy[dir];
                if (nx < 0 || ny < 0 || nx >= n || ny >= m) continue;

                if (board[nx][ny] == 1) { // 벽인 경우
                    if (dist[nx][ny] > cost + 1) { // 벽인 경우 부수는 cost가 1증가하기 때문에 cost+1과 비교
                        dist[nx][ny] = cost + 1;
                        pq.add(new Node(nx, ny, dist[nx][ny]));
                    }
                }

                else {
                    if (dist[nx][ny] > cost) {
                        dist[nx][ny] = cost;
                        pq.add(new Node(nx, ny, dist[nx][ny]));
                    }
                }
            }
        }
    }

    public static class Node {
        int x;
        int y;
        int cost;
        public Node(int x, int y, int cost) {
            this.x = x;
            this.y = y;
            this.cost = cost;
        }
    }
}
