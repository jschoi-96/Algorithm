import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
    테이블: d[i]: 합이 i일때 만들 수 있는 동전의 최소 개수
    점화식: d[i] =
 */
public class Main {
    static int n, k;
    static int min = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        int [] coins = new int[n];
        int[] d = new int[k + 1];
        for(int i = 0; i < n; i++) {
            coins[i] = Integer.parseInt(br.readLine());
        }

        Arrays.fill(d, Integer.MAX_VALUE);
        d[0] = 0;
        for(int coin : coins) {
            for(int i = coin; i <= k; i++){
                if (d[i-coin] != Integer.MAX_VALUE)
                    d[i] = Math.min(d[i], d[i-coin] + 1);
            }

        }
        if (d[k] == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(d[k]);
        }
    }
}
