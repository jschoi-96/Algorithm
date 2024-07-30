import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int t, m, n, k;
    static int [][] board;
    static boolean [][] visited;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        t = Integer.parseInt(br.readLine());

        for(int u = 0; u < t; u++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            m = Integer.parseInt(st.nextToken());
            n = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());

            board = new int[m + 2][n + 2];
            visited = new boolean[m + 2][n + 2];
            int cnt = 0;
            Queue<int []> q = new LinkedList<>();
            for(int j = 0; j < k; j++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                board[x][y] = 1;
            }

            for(int i = 0; i < m; i++) {
                for(int j = 0; j < n; j++) {
                    if (!visited[i][j] && board[i][j] == 1) {
                        cnt++;
                        q.add(new int[]{i, j});

                        while(!q.isEmpty()) {
                            int [] cur = q.poll();

                            int x = cur[0];
                            int y = cur[1];
                            for(int dir = 0; dir < 4; dir++){
                                int nx = x + dx[dir];
                                int ny = y + dy[dir];
                                if (nx < 0 || ny < 0 || nx >= m || ny >= n) continue;
                                if (visited[nx][ny] || board[nx][ny] == 0) continue;

                                visited[nx][ny] = true;
                                q.add(new int[]{nx, ny});
                            }

                        }
                    }
                }
            }
            sb.append(cnt).append("\n");
        }
        System.out.println(sb);
    }

}
