import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int n, m;
    static int[][] board;
    static int[][] time;
    static boolean[] visited = new boolean[12]; // 10보타 살짝 크게
    static List<int[]> virus = new ArrayList<>();
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int minTime = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        board = new int[n][n];
        time = new int[n][n];
        int emptyCnt = 0;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
                if (board[i][j] == 2) {
                    virus.add(new int[]{i, j});
                    time[i][j] = -2; // 바이러스 시간 배열에 표기
                }
                else if (board[i][j] == 1) time[i][j] = -1; // 벽인 경우, 시간 배열에 표기
                else if (board[i][j] == 0) emptyCnt++;
            }
        }

        if (emptyCnt == 0) {
            System.out.println(0);
            return;
        }

        dfs(0, 0);
        if (minTime == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(minTime);
        }
    }

    public static void dfs(int cur, int depth) {
        if (depth == m) {
            bfs();
            return;
        }

        for(int i = cur; i < virus.size(); i++) {
            if (!visited[i]) {
                visited[i] = true;
                int[] pos = virus.get(i);
                time[pos[0]][pos[1]] = -3; // 바이러스를 활성화 시켜줌
                dfs(i + 1, depth + 1);
                time[pos[0]][pos[1]] = -2; // 다시 비활성화
                visited[i] = false;
            }
        }
    }

    public static void bfs() {
        int[][] copy = copyTime();
        boolean[][] visited = new boolean[n][n];
        Queue<int[]> q = new LinkedList<>();

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if (copy[i][j] == -3) {
                    q.add(new int[]{i, j});
                    visited[i][j] = true;
                    copy[i][j] = 0; // 바이러스를 퍼트리는 시간 0으로 초기화
                }
            }
        }

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0], y = cur[1];
            for(int dir = 0; dir < 4; dir++) {
                int nx = x + dx[dir], ny = y + dy[dir];
                if (nx < 0 || ny < 0 || nx >= n || ny >= n) continue;
                if (visited[nx][ny] || board[nx][ny] == 1) continue;

                copy[nx][ny] = copy[x][y] + 1;
                visited[nx][ny] = true;
                q.add(new int[]{nx, ny});

            }
        }

        int max = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 0) { // 바이러스 칸에 있는 시간 값은 고려 x
                    if (!visited[i][j]) return;
                    max = Math.max(max, copy[i][j]);
                }
            }
        }

        minTime = Math.min(max, minTime);
    }

    public static int[][] copyTime() {
        int[][] copy = new int[n][n];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                copy[i][j] = time[i][j];
            }
        }
        return copy;
    }
}