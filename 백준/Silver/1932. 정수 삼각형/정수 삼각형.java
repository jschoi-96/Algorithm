import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[][] arr = new int[n][n];
        for(int i = 0; i < n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j <= i; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[][] dp = new int[n][n];
        dp[0][0] = arr[0][0];
        for(int i = 1; i < n; i++){
            for(int j = 0; j <= i; j++) {
                if (j == 0) dp[i][j] = dp[i-1][j] + arr[i][j];
                else if (i == j) dp[i][j] = dp[i-1][j-1] + arr[i][j];
                else dp[i][j] = Math.max(dp[i-1][j-1], dp[i-1][j]) + arr[i][j];
            }
        }

        int res = 0;
        for(int i = 0; i < n; i++) {
            res = Math.max(res, dp[n-1][i]);
        }
        System.out.println(res);
    }
}
