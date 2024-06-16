import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
    테이블: d[i]: 정수 i를 4개 이하의 제곱수로 표현하는 방법의 수
    점화식: dp[i] = Math.min(dp[i], dp[i - j*j] + 1)
 */
public class Main {
    static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        int [] dp = new int[n+1];

        dp[0] = 0;
        dp[1] = 1;

        for (int i = 2; i <= n; i++) dp[i] = Integer.MAX_VALUE;

        for(int i = 2; i <= n; i++) {
            for(int j = 1; j * j <= i; j++) {
                dp[i] = Math.min(dp[i], dp[i - j*j] + 1);
            }
        }

        System.out.println(dp[n]);
    }
}