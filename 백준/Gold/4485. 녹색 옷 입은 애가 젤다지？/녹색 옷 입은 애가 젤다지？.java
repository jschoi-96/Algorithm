import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int idx = 1;
        while (true) {
            int n = Integer.parseInt(br.readLine());

            if (n == 0) break;

            int[][] board = new int[n][n];
            int[][] dist = new int[n][n];
            boolean[][] visited = new boolean[n][n];
            for (int i = 0; i < n; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < n; j++) {
                    board[i][j] = Integer.parseInt(st.nextToken());
                    dist[i][j] = Integer.MAX_VALUE / 2;
                }
            }

            PriorityQueue<Node> pq = new PriorityQueue<>((a,b) -> Integer.compare(a.cost, b.cost));

            // 초기화
            pq.add(new Node(0, 0, board[0][0]));
            visited[0][0] = true;
            dist[0][0] = board[0][0];

            while(!pq.isEmpty()) {
                Node cur = pq.poll();
                int x = cur.x, y = cur.y, cost = cur.cost;
                for(int dir = 0; dir < 4; dir++) {
                    int nx = x + dx[dir], ny = y + dy[dir];
                    if (nx < 0 || ny < 0 || nx >= n || ny >= n || visited[nx][ny]) continue;
                    int nextCost = cost + board[nx][ny];

                    if (nextCost < dist[nx][ny]) {
                        visited[nx][ny] = true;
                        dist[nx][ny] = nextCost;
                        pq.add(new Node(nx, ny, nextCost));
                    }
                }
            }

            System.out.println("Problem " + idx++ + ": " + dist[n-1][n-1]);
        }
    }

    static class Node {
        int x, y, cost;
        public Node(int x, int y, int cost) {
            this.x = x;
            this.y = y;
            this.cost = cost;
        }
    }
}

