import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int [][] board;
    static boolean [] visited;
    static int res = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        // [1,2], [3,4]
        // [1,3], [2,4]
        // [1,4], [2,3]

        board = new int[n][n];
        visited = new boolean[n];
        for(int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0, 0);
        System.out.println(res);
    }

    public static void dfs(int idx, int cnt) {
        if (cnt == n/2) {
            int start = 0;
            int link = 0;

            for(int i = 0; i < n - 1; i++) {
                for(int j = i + 1; j < n; j++) {
                    if (visited[i] && visited[j]) {
                        start += board[i][j] + board[j][i];
                    }

                    if (!visited[i] && !visited[j]) {
                        link += board[i][j] + board[j][i];
                    }
                }
            }

            res = Math.min(res, Math.abs(start - link));
            return;
        }

        for(int i = idx; i < n; i++) {
            if (!visited[idx]) {
                visited[idx] = true;
                dfs(i + 1, cnt + 1);
                visited[idx] = false;
            }
        }
    }
}
