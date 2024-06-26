import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
    테이블: d[i]: i원을 만드는데 필요한 경우의 수
    점화식: d[i] = d[i] + d[i - coin]
 */
public class Main {
    static int n, k;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        int[] coins = new int[n];
        int[] d = new int[k+1];
        for(int i = 0; i < n; i++) {
            coins[i] = Integer.parseInt(br.readLine());
        }

        d[0] = 1;
        for(int coin : coins) {
            for(int j = 1; j <= k; j++) {
                if (j - coin >= 0)
                    d[j] = d[j - coin] + d[j]; // dp[6] = dp[4] + dp[6]
            }
        }
        System.out.println(d[k]);
    }
}
