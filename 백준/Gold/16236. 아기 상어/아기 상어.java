import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int[][] board;
    static boolean[][] visited;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        board = new int[n][n];
        visited = new boolean[n][n];

        Queue<Shark> q = new LinkedList<>();

        Shark shark = null;
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
                if (board[i][j] == 9) {
                    shark = new Shark(i, j, 2, 0, 0); // 시작점
                    // visited[i][j] = true;
                    board[i][j] = 0;
                }
            }
        }

        while (true) {
            PriorityQueue<Fish> pq = new PriorityQueue<>((a, b) -> {
                if (a.dist != b.dist) return a.dist - b.dist;
                if (a.x != b.x) return a.x - b.x;
                return a.y - b.y;
            });

            bfs(pq, shark);

            if (pq.isEmpty()) {
                System.out.println(shark.time);
                break;
            }

            Fish target = pq.poll();
            shark.x = target.x;
            shark.y = target.y;
            shark.eatCnt++;

            // System.out.println(shark.x + " " + shark.y + " " + target.dist);
            board[target.x][target.y] = 0; // 초기회
            shark.time += target.dist;

            if (shark.eatCnt == shark.size) {
                shark.size++;
                shark.eatCnt = 0;
            }
        }
    }

    public static void bfs(PriorityQueue<Fish> pq, Shark shark) {
        boolean[][] visited = new boolean[n][n];
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{shark.x, shark.y, 0});
        visited[shark.x][shark.y] = true;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0], y = cur[1], dist = cur[2];

            for(int dir = 0; dir < 4; dir++) {
                int nx = x + dx[dir];
                int ny = y + dy[dir];
                if (nx < 0 || ny < 0 || nx >= n || ny >= n) continue;
                if (visited[nx][ny] || board[nx][ny] > shark.size) continue; // 방문 처리 되었거나 먹을 수 없는경우

                if (board[nx][ny] > 0 && board[nx][ny] < shark.size) pq.add(new Fish(nx, ny, dist + 1));
                q.add(new int[]{nx, ny, dist + 1});

                visited[nx][ny] = true;
            }

        }
    }

    public static boolean checkEatable(int size) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] > 0 && board[i][j] <= size) return false;
            }
        }
        return true;
    }

    public static class Fish {
        int x;
        int y;
        int dist;
        public Fish(int x, int y, int dist) {
            this.x = x;
            this.y = y;
            this.dist = dist;
        }
    }

    public static class Shark {
        int x;
        int y;
        int size;
        int eatCnt;
        int time;
        public Shark(int x, int y, int size, int eatCnt, int time) {
            this.x = x;
            this.y = y;
            this.size = size;
            this.eatCnt = eatCnt;
            this.time = time;
        }
    }
}
