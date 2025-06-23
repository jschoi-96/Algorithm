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
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int minTime = Integer.MAX_VALUE;
    static List<int[]> virus = new ArrayList<>();
    static int empty = 0;
    static boolean[] check;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        board = new int[n][n];
        time = new int[n][n];
        check = new boolean[12];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
                if (board[i][j] == 1) time[i][j] = -1; // 벽일 때
                else if (board[i][j] == 2) {
                    time[i][j] = -2; // 바이러스
                    virus.add(new int[]{i, j});
                }
                else if (board[i][j] == 0) empty++;
            }
        }

        dfs(0,  0);
        if (minTime == Integer.MAX_VALUE) System.out.println(-1);
        else System.out.println(minTime);
    }

    public static void dfs(int cur, int depth) {
        if (depth == m) {
            bfs();
            return;
        }

        for(int i = cur; i < virus.size(); i++) {
            if (check[i]) continue;
            int[] pos = virus.get(i);
            check[i] = true;
            time[pos[0]][pos[1]] = -3; // 활성 바이러스 표시
            dfs(i + 1, depth + 1);
            check[i] = false;
            time[pos[0]][pos[1]] = -2; // 비활성으로 원복
        }
    }

    public static void bfs() {
        int[][] copy = copyTime();
        boolean[][] visited = new boolean[n][n];
        Queue<int[]> q = new LinkedList<>();

        int maxTime = 0;
        int cnt = empty;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if (copy[i][j] == -3) {
                    copy[i][j] = 0;
                    q.add(new int[] {i, j});
                    visited[i][j] = true;
                }
            }
        }

        while(!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0];
            int y = cur[1];
            for(int dir = 0; dir < 4; dir++) {
                int nx = x + dx[dir];
                int ny = y + dy[dir];
                if (nx < 0 || ny < 0 || nx >= n || ny >= n) continue;
                if (visited[nx][ny] || copy[nx][ny] == -1) continue;

                if (board[nx][ny] == 0) { // 빈칸일 때
                    cnt--;
                    copy[nx][ny] = copy[x][y] + 1;
                    maxTime = Math.max(maxTime, copy[nx][ny]);
                }

                else copy[nx][ny] = copy[x][y] + 1; // 바이러스를 지나갈 때 
                q.add(new int[] {nx, ny});
                visited[nx][ny] = true;
            }
        }

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if (board[i][j] == 0 && !visited[i][j]) {
                    return;
                }
            }
        }


        if (cnt == 0) minTime = Math.min(minTime, maxTime);
        // print(copy);
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

    public static void print(int[][] copy) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(copy[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}