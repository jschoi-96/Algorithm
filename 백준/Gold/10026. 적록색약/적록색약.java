import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static char [][] board;
    static boolean [][] visited;
    static Queue<int[]> queue = new LinkedList<>();
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        board = new char[n][n];
        visited = new boolean[n][n];
        for(int i = 0; i < n; i++){
            String temp = br.readLine();
            for(int j = 0; j < n; j++){
                board[i][j] = temp.charAt(j);
            }
        }

        System.out.println(normal(n) + " " + notNormal(n));
    }

    public static int normal(int n) {
        int result = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if (!visited[i][j]) {
                    queue.add(new int[]{i, j});
                    visited[i][j] = true;
                    while(!queue.isEmpty()) {
                        int [] cur = queue.poll();
                        int x = cur[0];
                        int y = cur[1];
                        for(int dir = 0; dir < 4; dir++){
                            int nx = x + dx[dir];
                            int ny = y + dy[dir];
                            if (nx < 0 || ny < 0 || nx >= n || ny >= n) continue;
                            if (board[nx][ny] != board[x][y] || visited[nx][ny]) continue;
                            visited[nx][ny] = true;
                            queue.add(new int[]{nx, ny});
                        }
                    }
                    result++;
                }
            }
        }
        return result;
    }

    public static void reset(int n) {
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if (board[i][j] == 'R') {
                    board[i][j] = 'G';
                }
            }
        }
    }

    public static int notNormal(int n) {
        int result = 0;
        reset(n);
        visited = new boolean[n][n];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if (!visited[i][j]) {
                    queue.add(new int[]{i, j});
                    visited[i][j] = true;
                    while(!queue.isEmpty()) {
                        int [] cur = queue.poll();
                        int x = cur[0];
                        int y = cur[1];
                        for(int dir = 0; dir < 4; dir++){
                            int nx = x + dx[dir];
                            int ny = y + dy[dir];
                            if (nx < 0 || ny < 0 || nx >= n || ny >= n) continue;
                            if (board[nx][ny] != board[x][y] || visited[nx][ny]) continue;
                            visited[nx][ny] = true;
                            queue.add(new int[]{nx, ny});
                        }
                    }
                    result++;
                }
            }
        }
        return result;
    }
}