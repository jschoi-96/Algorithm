import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
    테이블: d[i][j]: i,j좌표에 도착했을 때 경로 개수의 총합
    점화식:
        * d[i][j + board[i][j]] += dp[i][j]
        * d[i + board[i][j]] += dp[i][j]
 */
public class Main {
    static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        int[][] board = new int[n + 1][n + 1];
        long [][] dp = new long[n + 1][n + 1];
        for(int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= n; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dp[1][1] = 1; // 값 초기 설정
        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= n; j++) {
                int next = board[i][j];
                if (next == 0) continue;
                if (j + next <= n) dp[i][j + next] += dp[i][j];
                if (i + next <= n) dp[i + next][j] += dp[i][j];

            }
        }

//        for(int i = 1; i <= n; i++) {
//            for(int j = 1; j <= n; j++) {
//                System.out.print(dp[i][j] + " ");
//            }
//            System.out.println();
//        }
        System.out.println(dp[n][n]);
    }
}