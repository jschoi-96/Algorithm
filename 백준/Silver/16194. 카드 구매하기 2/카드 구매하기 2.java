import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
    테이블: d[i]: 카드 i개를 만들 때 지불하는 금액의 최솟값
    점화식: d[i] = Math.min(d[i], s[i] + d[i-j])
 */
public class Main {
    static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        int[] s = new int[n + 1];
        int[] d = new int[n + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= n; i++) {
            s[i] = Integer.parseInt(st.nextToken());
            d[i] = Integer.MAX_VALUE;
        }

        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= i; j++) {
                d[i] = Math.min(d[i], s[j] + d[i - j]);
            }
        }

        System.out.println(d[n]);
    }
}
