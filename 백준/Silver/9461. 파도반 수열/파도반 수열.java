import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        long[] dp = new long[102];
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 1;
        for(int i = 3; i <= 100; i++) {
            dp[i] = dp[i-2] + dp[i-3];
        }

        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());

            if (n == 1 || n == 2) sb.append(1).append("\n");
            else if (n == 3) sb.append(1).append("\n");
            else sb.append(dp[n-1]).append("\n");
        }

        System.out.println(sb);
    }
}
