import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] arr;
    static int n;
    static long cnt = 0;
    static long[][] dp; // dp[i][j]: i번째 숫자까지 계산했을 때 결과가 j가 되는 경우의 수

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        dp = new long[n - 1][22];
        dp[0][arr[0]] = 1; // 첫번째 만드는경우는 언제나 1개

        for (int i = 1; i < n - 1; i++) {
            for (int j = 0; j <= 20; j++) {
                if (j - arr[i] >= 0)
                    dp[i][j] += dp[i - 1][j - arr[i]];
                if (j + arr[i] <= 20)
                    dp[i][j] += dp[i - 1][j + arr[i]];
            }
        }

        System.out.println(dp[n - 2][arr[n - 1]]);
    }
}
