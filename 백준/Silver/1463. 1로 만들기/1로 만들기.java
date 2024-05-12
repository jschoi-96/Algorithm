import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n;
    public static void main(String[] args) throws IOException {
        int [] dp = new int[1000005];
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        dp[1] = 0;
        for(int i = 2; i <= n; i++) {
            dp[i] = dp[i-1] + 1;
            if (i % 3 == 0) dp[i] = Math.min(dp[i], dp[i/3] + 1);
            if (i % 2 == 0) dp[i] = Math.min(dp[i], dp[i/2] + 1);
        }
        System.out.println(dp[n]);
    }
}