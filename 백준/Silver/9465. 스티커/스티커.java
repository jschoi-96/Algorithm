import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
    테이블:
        * d[0][i]: i번째 열에 도달했을 때 아무 스티커도 선택하지 않을때 최고점수
        * d[1][i]: i번째 열에 도달했을 때 위쪽 스티커를 선택할 때 최고점수
        * d[2][i]: i번째 열에 도착했을 때 아래쪽 스티커를 선택할 때 최고점수
    점화식
        * d[0][i]= Math.max(d[0][i-1], d[1][i-1], d[2][i-1])
        * d[1][i] = Math.max(d[0][i-1], d[2][i-1]) + sticker[0][i]
        * d[2][i] = Math.max(d[0][i-1], d[1][i-1]) + sticker[1][i]

 */
public class Main {
    static int t;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        t = Integer.parseInt(br.readLine());

        for(int test = 0; test < t; test++) {
            int n = Integer.parseInt(br.readLine());
            int [][] sticker = new int[2][n+1];
            int[][] dp = new int[3][n + 1];

            for(int i = 0; i < 2; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for(int j = 0; j < n; j++) {
                    sticker[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            dp[0][0] = 0; dp[1][0] = sticker[0][0];
            dp[2][0] = sticker[1][0];
            for(int i = 1; i <= n; i++) {
                dp[0][i] = Math.max(Math.max(dp[0][i - 1], dp[1][i - 1]), dp[2][i - 1]);
                dp[1][i] = Math.max(dp[0][i - 1], dp[2][i - 1]) + sticker[0][i];
                dp[2][i] = Math.max(dp[0][i - 1], dp[1][i - 1]) + sticker[1][i];
            }

            sb.append(Math.max(Math.max(dp[0][n], dp[1][n]), dp[2][n])).append("\n");
        }
        System.out.println(sb.toString().trim());
    }
}