import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
    테이블: d[i]: i번째 날에 받을 수 있는 최대 금액
    점화식: d[j]: Math.max(d[j], d[i] + money)
 */
public class Main {
    static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        int[] t = new int[n + 1];
        int[] p = new int[n + 1];
        int[] d = new int[n + 2];

        for(int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            t[i] = Integer.parseInt(st.nextToken());
            p[i] = Integer.parseInt(st.nextToken());

        }

        for(int i = 1; i <= n; i++) {
            int day = t[i];
            int money = p[i];
            if (i + day <= n + 1) {
                d[i + day] = Math.max(d[i + day], d[i] + money);
            }
            d[i+1] = Math.max(d[i+1], d[i]);
        }

        System.out.println(d[n+1]);

    }
}
