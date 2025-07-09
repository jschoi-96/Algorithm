import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int n, m;
    static int[][] board;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int point = 0;
    static boolean flag = false;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        board = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        while (true) {
            bfs();
            if (flag) {
                System.out.println(point);
                return;
            }
            gravity();
            rotate();
            gravity();
        }
    }

    private static void bfs() {
        boolean[][] nVisited = new boolean[n][n]; // 일반 블록 방문체크
        Queue<int[]> q = new LinkedList<>();

        PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> {
            if (a.size != b.size) return b.size - a.size;
            if (a.rainbowSize != b.rainbowSize) return b.rainbowSize - a.rainbowSize;
            if (a.r != b.r) return b.r - a.r;
            return b.c - a.c;
        });

        List<int[]> rainbowPos = new ArrayList<>(); // 나중에 초기화
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!nVisited[i][j] && board[i][j] > 0) { // 방문되지 않은 일반 블록인경우
                    boolean[][] visited = new boolean[n][n]; // 일반 bfs 방문처리
                    q.add(new int[]{i, j});
                    nVisited[i][j] = true;
                    visited[i][j] = true;

                    int size = 1, rainbowSize = 0, r = i, c = j, startColor = board[i][j];
                    while (!q.isEmpty()) {
                        int[] cur = q.poll();
                        int x = cur[0], y = cur[1];
                        for(int dir = 0; dir < 4; dir++) {
                            int nx = x + dx[dir], ny = y + dy[dir];
                            if (nx < 0 || ny < 0 || nx >= n || ny >= n) continue;
                            if (visited[nx][ny] || board[nx][ny] == -1) continue; // 방문했거나 검은색 블록인 경우
                            if (board[nx][ny] == 0) {
                                rainbowSize++;
                                visited[nx][ny] = true;
                                rainbowPos.add(new int[]{nx, ny});
                                visited[nx][ny] = true;
                                q.add(new int[]{nx, ny});
                                size++;
                            }

                            else if (board[nx][ny] == startColor) { // 일반 블록
                                if (nx < r) { // 행이 더 작다면 갱신
                                    r = nx;
                                    c = ny;
                                }

                                else if (nx == r) { // 행이 같다면 열 비교
                                    if (ny == c) c = ny;
                                }

                                visited[nx][ny] = true;
                                nVisited[nx][ny] = true;
                                q.add(new int[]{nx, ny});
                                size++;
                            }
                        }
                    }

                    if (size >= 2) pq.add(new Node(r, c, rainbowSize, size));

                    for(int[] pos : rainbowPos) { // 무지개 블록 방문 처리를 해제
                        visited[pos[0]][pos[1]] = false;
                    }
                }
            }
        }

        if (pq.isEmpty()) {
            flag = true;
            return;
        }
        removeBlocks(pq);
    }

    public static void removeBlocks(Queue<Node> pq) {
        Node node = pq.poll();
        int x = node.r;
        int y = node.c;
        Queue<int[]> q = new LinkedList<>();
        boolean[][] visited = new boolean[n][n];

        q.add(new int[]{x, y});
        visited[x][y] = true;

        while(!q.isEmpty()) {
            int[] cur = q.poll();
            int x1 = cur[0], y1 = cur[1];
            for(int dir = 0; dir < 4; dir++) {
                int nx = x1 + dx[dir], ny = y1 + dy[dir];
                if (nx < 0 || ny < 0 || nx >= n || ny >= n) continue;
                if (visited[nx][ny] || board[nx][ny] == -1) continue;
                if (board[nx][ny] == 0 || board[nx][ny] == board[x][y]) {
                    q.add(new int[]{nx, ny});
                    visited[nx][ny] = true;
                    board[nx][ny] = -2;
                }
            }
        }
        board[x][y] = -2; // 마지막으로 시작점 제거
        point += node.size * node.size;
    }

    public static void gravity() {
        for(int j = 0; j < n; j++){
            for(int i = n - 2; i >= 0; i--) {
                if (board[i][j] >= 0) { // 현재 블록이 일반 또는 무지개
                    int cur = i;
                    while(cur + 1 < n && board[cur + 1][j] == -2) {
                        board[cur + 1][j] = board[cur][j];
                        board[cur][j] = -2;
                        cur++;
                    }
                }
            }
        }

    }

    public static void rotate() {
        int[][] newBoard = new int[n][n];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                newBoard[n-1-j][i] = board[i][j];
            }
        }
        board = newBoard;
    }

    public static void printBoard() {
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }


    public static class Node {
        int r, c, rainbowSize, size;
        public Node(int r, int c, int rainbowSize, int size) {
            this.r = r;
            this.c = c;
            this.rainbowSize = rainbowSize;
            this.size = size;
        }
    }
}
