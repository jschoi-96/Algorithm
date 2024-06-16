import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
    테이블: d[n]: 1x2, 2x2, 2x1타일로 채우는 방법의 수
    점화식: d[n] = d[n-1] * 2*d[n-2]
 */
public class Main {
    static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        int[] d = new int[n + 1];
        d[0] = 1;
        d[1] = 1;
        for(int i = 2; i <= n; i++) {
            d[i] = (d[i - 1] + 2 * d[i - 2]) % 10007;
        }

        System.out.println(d[n]);
    }
}