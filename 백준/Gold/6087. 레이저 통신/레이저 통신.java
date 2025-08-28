import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int w, h;
    static char[][] board;
    static int[] dx = {0, -1, 0, 1};
    static int[] dy = {1, 0, -1, 0};
    static int min_mirror = Integer.MAX_VALUE;
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

        board[x][y] = '.'; // 시작점 초기화
        Node start = new Node(x, y, -1, 0);
        bfs(start);

        System.out.println(min_mirror);
    }

    public static void bfs (Node start) {
        int[][][] visited = new int[h][w][4];
        for(int i = 0; i < h; i++) {
            for(int j = 0; j < w; j++) {
                for(int d = 0; d < 4; d++) {
                    visited[i][j][d] = Integer.MAX_VALUE;
                }
            }
        }

        PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> a.mirror - b.mirror);
        for(int i = 0; i < 4; i++) {
            visited[start.x][start.y][i] = 0;
            pq.add(new Node(start.x, start.y, i, 0));
        }

        while(!pq.isEmpty()) {
            Node cur = pq.poll();
            int x = cur.x;
            int y = cur.y;

            if (board[x][y] == 'C') { // 도착했을 때 거울의 최소 개수 갱신
                min_mirror = Math.min(min_mirror, cur.mirror);
            }

            if (visited[x][y][cur.dir] < cur.mirror) continue; // 최적경로가 아니기 때문에 스킵

            for(int dir = 0; dir < 4; dir++) {
                int nx = x + dx[dir];
                int ny = y + dy[dir];
                if (nx < 0 || nx >= h || ny < 0 || ny >= w || board[nx][ny] == '*') continue;

                int mirror_cnt = cur.mirror;
                if (cur.dir != dir) mirror_cnt++;

                if (visited[nx][ny][dir] > mirror_cnt) {
                    visited[nx][ny][dir] = mirror_cnt;
                    pq.add(new Node(nx, ny, dir, mirror_cnt));
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
