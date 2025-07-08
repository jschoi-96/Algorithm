import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static boolean isPossible;
    static int arrivalTime;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int k = 0; k < n; k++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int w = Integer.parseInt(st.nextToken());
            int h = Integer.parseInt(st.nextToken());

            char[][] board = new char[h][w];
            int[][] time = new int[h][w];
            Queue<int[]> f = new LinkedList<>();
            Queue<int[]> s = new LinkedList<>();

            isPossible = false; // 초기화
            arrivalTime = 0;
            for(int i = 0; i < h; i++) {
                for(int j = 0; j < w; j++) {
                    time[i][j] = 1000;
                }
            }

            for(int i = 0; i < h; i++) {
                String input = br.readLine();
                for(int j = 0; j < w; j++) {
                    board[i][j] = input.charAt(j);
                    if (board[i][j] == '*') {
                        f.add(new int[]{i, j});
                        time[i][j] = 0;
                    }
                    else if (board[i][j] == '@') s.add(new int[]{i, j});
                }
            }

            bfsFire(board, f, time);
            bfsSang(board, s, time);
            //printTime(time);

            if (isPossible) sb.append(arrivalTime).append("\n");
            else sb.append("IMPOSSIBLE").append('\n');
        }

        System.out.println(sb);
    }

    public static void bfsFire(char[][] board, Queue<int[]> f, int[][] time) {
        int n = board.length, m = board[0].length;
        boolean[][] visited = new boolean[n][m];

        while (!f.isEmpty()) {
            int[] cur = f.poll();
            int x = cur[0], y = cur[1];
            visited[x][y] = true;

            for(int dir = 0; dir < 4; dir++) {
                int nx = x + dx[dir], ny = y + dy[dir];
                if (nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
                if (visited[nx][ny] || board[nx][ny] == '#' || board[nx][ny] == '*') continue;

                time[nx][ny] = time[x][y] + 1;
                visited[nx][ny] = true;
                f.add(new int[]{nx, ny});
            }
        }
    }

    public static void bfsSang(char[][] board, Queue<int[]> f, int[][] time) {
        int n = board.length, m = board[0].length;
        boolean[][] visited = new boolean[n][m];
        int[][] sangTime = new int[n][m];
        while (!f.isEmpty()) {
            int[] cur = f.poll();
            int x = cur[0], y = cur[1];
            visited[x][y] = true;

            if (x == 0 || y == 0 || x == n - 1 || y == m - 1) {
                isPossible = true;
                arrivalTime = sangTime[x][y] + 1;
                return;
            }

            for(int dir = 0; dir < 4; dir++) {
                int nx = x + dx[dir], ny = y + dy[dir];
                if (nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
                if (visited[nx][ny] || board[nx][ny] == '#' || board[nx][ny] == '*') continue;
                if (time[nx][ny] <= sangTime[x][y] + 1) continue; // 불이 도달한 시각이 더 빠른경우

                sangTime[nx][ny] = sangTime[x][y] + 1;
                visited[nx][ny] = true;
                f.add(new int[]{nx, ny});
            }
        }
        //printTime(sangTime);
    }

    public static void printTime(int[][] time) {
        for(int i = 0; i < time.length; i++) {
            for(int j = 0; j < time[i].length; j++) {
                System.out.print(time[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
