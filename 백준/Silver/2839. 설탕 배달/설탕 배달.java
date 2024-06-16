import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
    테이블: d[i]: i킬로그램의 설탕을 배달할 떄 최대한 적은 n개의 봉지를 들고가는 경우의 수
    점화식: d[i] = min(dp[i-3], dp[i-5]) + 1
 */
public class Main {
    static int n;
    static int [] d = new int[5002];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        for(int i = 1; i <= n; i++) {
            d[i] = Integer.MAX_VALUE;
        }

        d[0] = 0;
        for(int i = 1; i <= n; i++) {
            if(i >= 3 && d[i-3] != Integer.MAX_VALUE) {
                d[i] = Math.min(d[i], d[i-3]) + 1;
            }
            if (i >= 5 && d[i-5] != Integer.MAX_VALUE) {
                d[i] = Math.min(d[i], d[i-5]) + 1;
            }
        }

        if (d[n] == Integer.MAX_VALUE) {
            System.out.println(-1);
            return;
        }
        System.out.println(d[n]);
    }
}