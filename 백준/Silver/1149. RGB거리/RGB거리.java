import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
    1. 테이블 정의
        * d[i][0]: i번째 집까지 칠할때 최솟값, i번째 집은 빨강
        * d[i][1]: i번째 초록
        * d[i][2]: i번째 파랑
    2. 점화식
        * d[k][0] = min(d[k-1][1], d[k-1][2]) + r[k]
 */
public class Main {
    static int n;
    static int [] r = new int[1002];
    static int [] g = new int[1002];
    static int[] b = new int[1002];
    static int [][] dp = new int[1002][3];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        for(int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            r[i] = Integer.parseInt(st.nextToken());
            g[i] = Integer.parseInt(st.nextToken());
            b[i] = Integer.parseInt(st.nextToken());
        }

        dp[1][0] = r[1];
        dp[1][1] = g[1];
        dp[1][2] = b[1];

        for(int i = 2; i <= n; i++) {
            dp[i][0] = Math.min(dp[i - 1][1], dp[i - 1][2]) + r[i];
            dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][2]) + g[i];
            dp[i][2] = Math.min(dp[i - 1][0], dp[i - 1][1]) + b[i];
        }

        System.out.println(Math.min(Math.min(dp[n][0],dp[n][1]),dp[n][2]));

    }
}