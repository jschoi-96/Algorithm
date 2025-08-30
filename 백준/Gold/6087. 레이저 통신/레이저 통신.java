import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int w, h;
    static char[][] board;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, -1, 0, 1};
    static int res = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        w = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());

        board = new char[h][w];
        int x = 0, y = 0;
        for (int i = 0; i < h; i++) {
            String input = br.readLine();
            for (int j = 0; j < w; j++) {
                board[i][j] = input.charAt(j);
                if (board[i][j] == 'C') {
                    x = i;
                    y = j;
                }
            }
        }

        board[x][y] = '.'; // 시작점은 초기화 해줌
        bfs(x, y);

        System.out.println(res);
    }

    public static void bfs(int x, int y) {
        int[][][] visited = new int[h][w][4]; // 4가지 방향을 모두 체크하기 위해서 3차원 배열 선언ㅇ
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                for(int k = 0; k < 4; k++) {
                    visited[i][j][k] = Integer.MAX_VALUE;
                }
            }
        }

        PriorityQueue<Node> pq = new PriorityQueue<>((a,b) -> a.mirror - b.mirror);
        for(int i = 0; i < 4; i++) {
            visited[x][y][i] = 0; // 시작점 초기화
            pq.add(new Node(x, y, i, 0)); // 해당 지점에서 4가지 방향으로 가는 케이스 전부 고려
        }

        while(!pq.isEmpty()) {
            Node cur = pq.poll();

            if (board[cur.x][cur.y] == 'C') {
                res = Math.min(res, cur.mirror);
            }

            // 방문하려는 곳이 현재 거울 개수보다 더 필요하다면 건너뜀
            if (visited[cur.x][cur.y][cur.dir] < cur.mirror) continue;

            for(int dir = 0; dir < 4; dir++) {
                int nx = cur.x + dx[dir];
                int ny = cur.y + dy[dir];

                if (nx < 0 || ny < 0 || nx >= h || ny >= w || board[nx][ny] == '*') continue;
                int mirror = cur.mirror;
                if (cur.dir != dir) { // 방향이 다른 경우, 거울이 있었다는 뜻 이므로 횟수 증가
                    mirror++;
                }

                if (visited[nx][ny][dir] > mirror) {
                    visited[nx][ny][dir] = mirror;
                    pq.add(new Node(nx, ny, dir, mirror));
                }
            }
        }
    }

    public static class Node {
        int x;
        int y;
        int dir;
        int mirror;
        public Node(int x, int y, int dir, int mirror) {
            this.x = x;
            this.y = y;
            this.dir = dir;
            this.mirror = mirror;
        }
    }
}