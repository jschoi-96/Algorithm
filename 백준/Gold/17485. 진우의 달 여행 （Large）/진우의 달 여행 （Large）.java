import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int n, m;
    static int[][] board;
    static int[] dx = {1,1,1};
    static int[] dy = {-1,0,1};
    static boolean[][] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        board = new int[n][m];
        visited = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int [][][] dp = new int[n][m][3]; // dp[i][j][이전 방향에서 온 값]
        for(int i = 0; i < m; i++) {
            dp[0][i][0] = board[0][i];
            dp[0][i][1] = board[0][i];
            dp[0][i][2] = board[0][i];
        }

        // 0 -> 왼쪽, 1 -> 위, 2-> 오른쪽
        int INF = 10000000;
        for(int i = 1; i < n; i++) {
            for(int j = 0; j < m; j++) {

                if (j == 0) {
                    dp[i][j][0] = INF; // 왼쪽 위에서 올 수 없으므로
                    dp[i][j][1] = Math.min(dp[i-1][j][0] + board[i][j], dp[i-1][j][2] + board[i][j]);
                    dp[i][j][2] = Math.min(dp[i-1][j+1][0] + board[i][j], dp[i-1][j+1][1] + board[i][j]);
                }

                else if (j == m-1) {
                    dp[i][j][0] = Math.min(dp[i-1][j-1][1] + board[i][j], dp[i-1][j-1][2] + board[i][j]);
                    dp[i][j][1] = Math.min(dp[i-1][j][0] + board[i][j], dp[i-1][j][2] + board[i][j]);
                    dp[i][j][2] = INF;
                }

                else {
                    dp[i][j][0] = Math.min(dp[i - 1][j - 1][1] + board[i][j], dp[i - 1][j - 1][2] + board[i][j]);
                    dp[i][j][1] = Math.min(dp[i-1][j][0] + board[i][j], dp[i-1][j][2] + board[i][j]);
                    dp[i][j][2] = Math.min(dp[i-1][j+1][0] + board[i][j] , dp[i-1][j+1][1] + board[i][j]);
                }
            }
        }

        int res = Integer.MAX_VALUE;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < 3; j++) {
                res = Math.min(res, dp[n - 1][i][j]);
            }
        }
        System.out.println(res);

    }
}
