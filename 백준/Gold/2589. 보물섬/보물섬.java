import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int n, m;
    static char [][] board;
    static int max = 0;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        board = new char[n][m];
        for(int i = 0; i < n; i++) {
            String input = br.readLine();
            for(int j = 0; j < m; j++) {
                board[i][j] = input.charAt(j);
            }
        }

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if (board[i][j] == 'L') {
                    bfs(i, j);
                }
            }
        }
        System.out.println(max);
    }

    public static void bfs (int i, int j) {
        boolean [][] visited = new boolean[n][m];
        Queue<int []> q = new LinkedList<>();
        q.add(new int[]{i,j});
        visited[i][j] = true;

        int tmp_dist = 0;
        int [][] dist = new int[n][m];

        while(!q.isEmpty()) {
            int [] cur = q.poll();
            int x = cur[0];
            int y = cur[1];
            for(int dir = 0; dir < 4; dir++) {
                int nx = x + dx[dir];
                int ny = y + dy[dir];
                if (nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
                if (visited[nx][ny] || board[nx][ny] == 'W') continue;
                visited[nx][ny] = true;
                q.add(new int[]{nx, ny});
                dist[nx][ny] = dist[x][y] + 1;
                max = Math.max(dist[nx][ny] , max);
            }
        }
        //System.out.println(max);

        //print(dist);
    }

//    public static void print(int [][] dist) {
//        for(int i = 0; i < n; i++) {
//            for(int j = 0; j < m; j++) {
//                System.out.print(dist[i][j] + " ");
//            }
//            System.out.println();
//        }
//        System.out.println();
//    }
}
